package pismeno.gagtweaks.mixins.late;

import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.util.GTUtility;
import gregtech.loaders.recipe.handlers.OreRecipeHandler;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import pismeno.gagtweaks.gregtech.GAGOrePrefix;
import slimeknights.tconstruct.library.TinkerRegistry;

import static gregtech.api.recipes.RecipeMaps.ARC_FURNACE_RECIPES;

@Mixin(
        value = {OreRecipeHandler.class},
        remap = false
)
public class MixinOreProcessing {

    /**
     * @author PismenoK
     * @reason Changing OreProcessing for the purposes of the modpack.
     */
    @Overwrite
    public static void processOre(OrePrefix orePrefix, Material material, OreProperty property) {

        Material byproductMaterial = property.getOreByProduct(0, material);
        ItemStack byproductStack = OreDictUnifier.get(OrePrefix.gem, byproductMaterial);

        if (byproductStack.isEmpty()) byproductStack = OreDictUnifier.get(OrePrefix.dust, byproductMaterial);

        ItemStack crushedStack = OreDictUnifier.get(OrePrefix.crushed, material);
        ItemStack ingotStack;

        Material smeltingMaterial = property.getDirectSmeltResult() == null ? material :
                property.getDirectSmeltResult();
        double amountOfCrushedOre = property.getOreMultiplier();

        if (smeltingMaterial.hasProperty(PropertyKey.INGOT)) {
            ingotStack = OreDictUnifier.get(OrePrefix.ingot, smeltingMaterial);
        } else if (smeltingMaterial.hasProperty(PropertyKey.GEM)) {
            ingotStack = OreDictUnifier.get(OrePrefix.gem, smeltingMaterial);
        } else {
            ingotStack = OreDictUnifier.get(OrePrefix.dust, smeltingMaterial);
        }

        int oreTypeMultiplier = orePrefix == GAGOrePrefix.oreFieryNetherrack || orePrefix == GAGOrePrefix.oreLivelyNetherrack
                || orePrefix == GAGOrePrefix.oreGloomyNetherrack || orePrefix == OrePrefix.oreNetherrack
                || orePrefix == OrePrefix.oreEndstone ? 2 : 1;

        ingotStack.setCount(ingotStack.getCount() * property.getOreMultiplier() * oreTypeMultiplier);
        crushedStack.setCount(crushedStack.getCount() * property.getOreMultiplier());

        if (!crushedStack.isEmpty()) {
            RecipeBuilder<?> builder = RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder()
                    .input(orePrefix, material)
                    .duration(10).EUt(16);
            if (material.hasProperty(PropertyKey.GEM) && !OreDictUnifier.get(OrePrefix.gem, material).isEmpty()) {
                builder.outputs(GTUtility.copy((int) Math.ceil(amountOfCrushedOre) * oreTypeMultiplier,
                        OreDictUnifier.get(OrePrefix.gem, material, crushedStack.getCount())));
            } else {
                builder.outputs(GTUtility.copy((int) Math.ceil(amountOfCrushedOre) * oreTypeMultiplier, crushedStack));
            }
            builder.buildAndRegister();

            builder = RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
                    .input(orePrefix, material)
                    .outputs(GTUtility.copy((int) Math.round(amountOfCrushedOre) * 2 * oreTypeMultiplier, crushedStack))
                    .chancedOutput(byproductStack, 1400, 850)
                    .duration(400);
            for (MaterialStack secondaryMaterial : orePrefix.secondaryMaterials) {
                if (secondaryMaterial.material.hasProperty(PropertyKey.DUST)) {
                    ItemStack dustStack = OreDictUnifier.getGem(secondaryMaterial);
                    builder.chancedOutput(dustStack, 6700, 800);
                }
            }

            builder.buildAndRegister();
        }

        if (!ingotStack.isEmpty() && doesMaterialUseNormalFurnace(smeltingMaterial)) {
            ARC_FURNACE_RECIPES.recipeBuilder()
                    .EUt(8).duration(100)
                    .input(orePrefix, material)
                    .outputs(ingotStack)
                    .buildAndRegister();

            if (canMaterialBeMelted(smeltingMaterial)) {
                TinkerRegistry.registerMelting(OreDictUnifier.get(orePrefix, material), smeltingMaterial.getFluid(), 144 * oreTypeMultiplier);
            }
        }
    }

    /**
     * @author PismenoK
     * @reason Changing OreProcessing for the purposes of the modpack.
     */
    @Overwrite
    private static void processMetalSmelting(OrePrefix crushedPrefix, Material material, OreProperty property) {
        Material smeltingResult = property.getDirectSmeltResult() != null ? property.getDirectSmeltResult() : material;

        if (smeltingResult.hasProperty(PropertyKey.INGOT)) {
            ItemStack ingotStack = OreDictUnifier.get(OrePrefix.ingot, smeltingResult);

            if (!ingotStack.isEmpty() && doesMaterialUseNormalFurnace(smeltingResult)) {
                ARC_FURNACE_RECIPES.recipeBuilder()
                        .EUt(8).duration(100)
                        .input(crushedPrefix, material)
                        .outputs(ingotStack)
                        .buildAndRegister();

                if (canMaterialBeMelted(smeltingResult)) {
                    TinkerRegistry.registerMelting(OreDictUnifier.get(crushedPrefix, material), smeltingResult.getFluid(), 144);
                }
            }
        }
    }

    private static boolean doesMaterialUseNormalFurnace(Material material) {
        return !material.hasProperty(PropertyKey.BLAST);
    }

    private static boolean canMaterialBeMelted(Material material) {
        return material.hasProperty(PropertyKey.INGOT) && material.hasFluid();
    }
}

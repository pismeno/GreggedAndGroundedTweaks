package pismeno.gftweaks.gregtech;

import com.mjr.extraplanets.items.ExtraPlanets_Items;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pismeno.gftweaks.common.GFTItems;

import java.util.Arrays;
import java.util.List;

import static gregtech.api.GTValues.*;

public class MachineRecipes {
    public static void init() {
        addGeneric();
        removeWoodPulpRecyclings();
    }

    private static void addGeneric() {
        RecipeMaps.IMPLOSION_RECIPES.recipeBuilder()
                .input(GFTItems.HEAVY_DUTY_COMPOSITE)
                .output(GFTItems.COMPRESSED_HEAVY_DUTY_COMPOSITE)
                .explosivesType(new ItemStack(MetaBlocks.POWDERBARREL, 8))
                .duration(20).EUt(VA[EV])
                .buildAndRegister();

        RecipeMaps.IMPLOSION_RECIPES.recipeBuilder()
                .input(GFTItems.HEAVY_DUTY_COMPOSITE)
                .output(GFTItems.COMPRESSED_HEAVY_DUTY_COMPOSITE)
                .explosivesAmount(4)
                .duration(20).EUt(VA[EV])
                .buildAndRegister();

        RecipeMaps.IMPLOSION_RECIPES.recipeBuilder()
                .input(GFTItems.HEAVY_DUTY_COMPOSITE)
                .output(GFTItems.COMPRESSED_HEAVY_DUTY_COMPOSITE)
                .explosivesType(MetaItems.DYNAMITE.getStackForm(2))
                .duration(20).EUt(VA[EV])
                .buildAndRegister();

        RecipeMaps.IMPLOSION_RECIPES.recipeBuilder()
                .input(GFTItems.HEAVY_DUTY_COMPOSITE)
                .output(GFTItems.COMPRESSED_HEAVY_DUTY_COMPOSITE)
                .explosivesType(new ItemStack(MetaBlocks.ITNT))
                .duration(20).EUt(VA[EV])
                .buildAndRegister();
    }

    private static void removeWoodPulpRecyclings() {
        List<ItemStack> woodDusts = Arrays.asList(
                OreDictUnifier.get(OrePrefix.dust, Materials.Wood),
                OreDictUnifier.get(OrePrefix.dustSmall, Materials.Wood),
                OreDictUnifier.get(OrePrefix.dustTiny, Materials.Wood),
                OreDictUnifier.get(OrePrefix.dust, Materials.TreatedWood),
                OreDictUnifier.get(OrePrefix.dustSmall, Materials.TreatedWood),
                OreDictUnifier.get(OrePrefix.dustTiny, Materials.TreatedWood)
        );


        for (Recipe recipe : RecipeMaps.MACERATOR_RECIPES.getRecipeList()) {
            for (ItemStack itemStack : recipe.getAllItemOutputs()) {
                for (ItemStack item : woodDusts){
                    if (itemStack.isItemEqual(item)) {
                        RecipeMaps.MACERATOR_RECIPES.removeRecipe(recipe);
                    }
                }
            }
        }
    }

    private  MachineRecipes() {}
}

package pismeno.gftweaks.common.recipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.category.RecipeCategories;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlags;

import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraftforge.fluids.FluidStack;
import pismeno.gftweaks.gregtech.GFTMaterialFlags;
import pismeno.gftweaks.gregtech.GFTOrePrefix;


public class MetaItemHandler {

    private MetaItemHandler() {}

    public static void init() {
        OrePrefix.plate.addProcessingHandler(MetaItemHandler::process);
    }

    private static void process(OrePrefix prefix, Material material) {
        if (material.hasFlag(MaterialFlags.GENERATE_PLATE) && material.hasFlag(GFTMaterialFlags.GENERATE_CUTTING_BLADE)) {
            RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
                    .input(GFTOrePrefix.cuttingBlade, material)
                    .output(OrePrefix.dust, material, 4)
                    .category(RecipeCategories.MACERATOR_RECYCLING)
                    .duration(300).EUt(8)
                    .buildAndRegister();

            RecipeMaps.ARC_FURNACE_RECIPES.recipeBuilder()
                    .input(GFTOrePrefix.cuttingBlade, material)
                    .output(OrePrefix.ingot, material, 4)
                    .category(RecipeCategories.ARC_FURNACE_RECYCLING)
                    .duration(300).EUt(30)
                    .buildAndRegister();

            RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                    .input(GFTOrePrefix.cuttingBlade, material)
                    .fluidOutputs(new FluidStack(material.getFluid(), 4 * 144))
                    .category(RecipeCategories.EXTRACTOR_RECYCLING)
                    .duration(300).EUt(120)
                    .buildAndRegister();

            ModHandler.addShapedRecipe(String.format("cutting_blade_%s", material),
                    OreDictUnifier.get(GFTOrePrefix.cuttingBlade, material),
                    "XsX", "f h", "XxX",
                    'X', new UnificationEntry(OrePrefix.plate, material));
        }
    }
}

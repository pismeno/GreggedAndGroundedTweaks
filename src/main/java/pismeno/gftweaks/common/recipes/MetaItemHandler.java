package pismeno.gftweaks.common.recipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.IOreRegistrationHandler;

import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import pismeno.gftweaks.gregtech.GFTOrePrefix;


public class MetaItemHandler {

    private MetaItemHandler() {}

    public static void init() {
        GFTOrePrefix.cuttingBlade.addProcessingHandler(process());
    }

    private static IOreRegistrationHandler process() {
        return (orePrefix, material) -> {
            ModHandler.addShapedRecipe(String.format("cutting_blade_%s", material),
                    OreDictUnifier.get(GFTOrePrefix.cuttingBlade, material),
                    "XsX", "h f", "XxX",
                    'X', new UnificationEntry(OrePrefix.plate, material));
        };
    }
}

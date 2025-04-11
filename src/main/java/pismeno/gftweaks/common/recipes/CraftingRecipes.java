package pismeno.gftweaks.common.recipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import gregtech.common.items.ToolItems;
import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.item.ItemStack;
import pismeno.gftweaks.common.GFTBlocks;
import pismeno.gftweaks.gregtech.GFTMaterials;

public class CraftingRecipes {

    public static void init() {
        removeToolRecipes();
        addRecipes();
    }

    private static void addRecipes() {
        ModHandler.addShapedRecipe("CarbonCasing", new ItemStack(GFTBlocks.CARBON_MACHINE_CASING), "CCC", "CwC", "CCC",
                'C', MetaItems.CARBON_FIBER_PLATE.getStackForm());

        ModHandler.addShapedRecipe("CarbonHull", new ItemStack(GFTBlocks.CARBON_MACHINE_HULL), "SES", "CHC",
                'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold),
                'H', new ItemStack(GFTBlocks.CARBON_MACHINE_CASING),
                'S', new ItemStack(GCItems.basicItem, 1, 9),
                'E', new UnificationEntry(OrePrefix.plate, GFTMaterials.Enori));
    }

    private static void removeToolRecipes() {
        ModHandler.removeRecipeByOutput(recipe -> recipe.getRecipeOutput().getItem() == ToolItems.AXE.get());
        ModHandler.removeRecipeByOutput(recipe -> recipe.getRecipeOutput().getItem() == ToolItems.PICKAXE.get());
        ModHandler.removeRecipeByOutput(recipe -> recipe.getRecipeOutput().getItem() == ToolItems.SHOVEL.get());
        ModHandler.removeRecipeByOutput(recipe -> recipe.getRecipeOutput().getItem() == ToolItems.SWORD.get());
        ModHandler.removeRecipeByOutput(recipe -> recipe.getRecipeOutput().getItem() == ToolItems.MINING_HAMMER.get());
        ModHandler.removeRecipeByOutput(recipe -> recipe.getRecipeOutput().getItem() == ToolItems.SPADE.get());
    }

    private CraftingRecipes() {}
}

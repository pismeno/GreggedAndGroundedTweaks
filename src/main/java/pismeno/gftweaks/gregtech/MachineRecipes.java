package pismeno.gftweaks.gregtech;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import pismeno.gftweaks.common.GFTItems;

import static gregtech.api.GTValues.*;

public class MachineRecipes {
    public static void init() {
        addGeneric();
    }

    public static void postInit() {
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
        for (Recipe recipe : RecipeMaps.MACERATOR_RECIPES.getRecipeList()) {
            for (ItemStack itemStack : recipe.getAllItemOutputs()) {
                if (itemStack.getItemDamage() == 1617 || itemStack.getItemDamage() == 1648) {
                    RecipeMaps.MACERATOR_RECIPES.removeRecipe(recipe);
                }
            }
        }

        for (Recipe recipe : RecipeMaps.CUTTER_RECIPES.getRecipeList()) {
            for (ItemStack itemStack : recipe.getAllItemOutputs()) {
                if (itemStack.getItemDamage() == 1617 || itemStack.getItemDamage() == 1648) {
                    RecipeMaps.CUTTER_RECIPES.removeRecipe(recipe);
                }
            }
        }

        for (Recipe recipe : RecipeMaps.LATHE_RECIPES.getRecipeList()) {
            for (ItemStack itemStack : recipe.getAllItemOutputs()) {
                if (itemStack.getItemDamage() == 1617 || itemStack.getItemDamage() == 1648) {
                    RecipeMaps.LATHE_RECIPES.removeRecipe(recipe);
                }
            }
        }
    }

    private  MachineRecipes() {}
}

package pismeno.gftweaks.gregtech;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.Recipe;

import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.CleanroomProperty;
import gregtech.api.unification.material.MarkerMaterials.Color;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import pismeno.gftweaks.common.GFTItems;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static pismeno.gftweaks.gregtech.GFTRecipeMaps.*;

public class MachineRecipes {
    public static void init() {
        addGeneric();
        registerDecoFabricatorRecipes();
        registerAAFlawlessRecipes();
        registerChipsRecipes();
    }

    public static void postInit() {
        removeWoodPulpRecyclings();
    }

    private static void addGeneric() {
        IMPLOSION_RECIPES.recipeBuilder()
                .input(GFTItems.HEAVY_DUTY_COMPOSITE)
                .output(GFTItems.COMPRESSED_HEAVY_DUTY_COMPOSITE)
                .explosivesType(new ItemStack(MetaBlocks.POWDERBARREL, 8))
                .duration(20).EUt(VA[EV])
                .buildAndRegister();

        IMPLOSION_RECIPES.recipeBuilder()
                .input(GFTItems.HEAVY_DUTY_COMPOSITE)
                .output(GFTItems.COMPRESSED_HEAVY_DUTY_COMPOSITE)
                .explosivesAmount(4)
                .duration(20).EUt(VA[EV])
                .buildAndRegister();

        IMPLOSION_RECIPES.recipeBuilder()
                .input(GFTItems.HEAVY_DUTY_COMPOSITE)
                .output(GFTItems.COMPRESSED_HEAVY_DUTY_COMPOSITE)
                .explosivesType(MetaItems.DYNAMITE.getStackForm(2))
                .duration(20).EUt(VA[EV])
                .buildAndRegister();

        IMPLOSION_RECIPES.recipeBuilder()
                .input(GFTItems.HEAVY_DUTY_COMPOSITE)
                .output(GFTItems.COMPRESSED_HEAVY_DUTY_COMPOSITE)
                .explosivesType(new ItemStack(MetaBlocks.ITNT))
                .duration(20).EUt(VA[EV])
                .buildAndRegister();
    }

    public static void registerChipsRecipes() {
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(OrePrefix.gemExquisite, Materials.Amethyst)
                .fluidInputs(new FluidStack(Materials.Argon.getFluid(), 100))
                .output(GFTOrePrefix.chipRaw, Materials.Amethyst)
                .duration(1200).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipRaw, Materials.Amethyst)
                .notConsumable(OrePrefix.craftingLens, Color.Purple)
                .output(GFTOrePrefix.chipEngraved, Materials.Amethyst)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    public static void registerAAFlawlessRecipes() {
        int i = 0;
        for (Material material : GFTMaterials.AAMaterials) {
            LASER_ENGRAVER_RECIPES.recipeBuilder()
                    .inputs(new ItemStack(InitItems.itemCrystalEmpowered, 2, i))
                    .notConsumable(OrePrefix.craftingLens, Color.White)
                    .output(OrePrefix.gemFlawless, material, 2)
                    .duration(240).EUt(VA[HV])
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
            i++;
        }
    }

    public static void registerDecoFabricatorRecipes() {
        for (Recipe recipe : RecipeMaps.LASER_ENGRAVER_RECIPES.getRecipeList()) {
            if (recipe.getDuration() == 50 && recipe.getEUt() == 16) {
                RecipeBuilder<?> recipeBuilder = LASER_FABRICATOR_RECIPES.recipeBuilder()
                        .inputs(recipe.getInputs().get(0))
                        .inputs(recipe.getInputs().get(1))
                        .duration(50)
                        .EUt((int) (recipe.getEUt() * 1.9F))
                        .outputs(recipe.getAllItemOutputs().get(0));

                if (recipe.hasProperty(CleanroomProperty.getInstance())) {
                    recipeBuilder.cleanroom(CleanroomType.CLEANROOM);
                }
                recipeBuilder.buildAndRegister();
            }
        }
    }

    private static void removeWoodPulpRecyclings() {
        for (Recipe recipe : MACERATOR_RECIPES.getRecipeList()) {
            for (ItemStack itemStack : recipe.getAllItemOutputs()) {
                if (itemStack.getItemDamage() == 1617 || itemStack.getItemDamage() == 1648) {
                    MACERATOR_RECIPES.removeRecipe(recipe);
                }
            }
        }

        for (Recipe recipe : CUTTER_RECIPES.getRecipeList()) {
            for (ItemStack itemStack : recipe.getAllItemOutputs()) {
                if (itemStack.getItemDamage() == 1617 || itemStack.getItemDamage() == 1648) {
                    CUTTER_RECIPES.removeRecipe(recipe);
                }
            }
        }

        for (Recipe recipe : LATHE_RECIPES.getRecipeList()) {
            for (ItemStack itemStack : recipe.getAllItemOutputs()) {
                if (itemStack.getItemDamage() == 1617 || itemStack.getItemDamage() == 1648) {
                    LATHE_RECIPES.removeRecipe(recipe);
                }
            }
        }
    }

    private  MachineRecipes() {}
}

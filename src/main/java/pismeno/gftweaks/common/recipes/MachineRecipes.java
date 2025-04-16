package pismeno.gftweaks.common.recipes;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.Recipe;

import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.CleanroomProperty;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.MarkerMaterials.Color;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import pismeno.gftweaks.common.GFTItems;
import pismeno.gftweaks.gregtech.GFTMaterials;
import pismeno.gftweaks.gregtech.GFTOrePrefix;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.BlueAlloy;
import static gregtech.api.unification.material.Materials.Electrum;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.items.MetaItems.WORKSTATION_EV;
import static pismeno.gftweaks.gregtech.GFTRecipeMaps.*;

public class MachineRecipes {
    public static void init() {
        addGeneric();
        registerDecoFabricatorRecipes();
        registerAAFlawlessRecipes();
        registerChipsRecipes();
        registerChipsetRecipes();
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

    public static void registerCircuits() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(400)
                .input(MetaItems.PLASTIC_CIRCUIT_BOARD)
                .input(MetaItems.PROCESSOR_ASSEMBLY_HV, 2)
                .input(OrePrefix.component, MarkerMaterials.Component.Diode, 4)
                .input(MetaItems.RANDOM_ACCESS_MEMORY, 4)
                .input(OrePrefix.wireFine, Materials.Electrum, 16)
                .input(GFTItems.COMPUTING_CHIPSET)
                .output(MetaItems.WORKSTATION_EV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    public static void registerChipsetRecipes() {
        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipEngraved, Materials.GarnetYellow)
                .input(OrePrefix.wireFine, Materials.RedAlloy, 12)
                .notConsumable(OrePrefix.craftingLens, Color.Yellow)
                .notConsumable(OrePrefix.lens, GFTMaterials.Restonia)
                .output(GFTItems.PROCESSING_CHIPSET)
                .duration(250).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipEngraved, GFTMaterials.Enori)
                .input(OrePrefix.wireFine, Materials.BlueAlloy, 12)
                .notConsumable(OrePrefix.lens, GFTMaterials.Enori)
                .notConsumable(OrePrefix.lens, GFTMaterials.Palis)
                .output(GFTItems.COMPUTING_CHIPSET)
                .duration(300).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipEngraved, Materials.Amethyst)
                .input(OrePrefix.wireFine, Materials.Silver, 12)
                .notConsumable(OrePrefix.craftingLens, Color.Purple)
                .notConsumable(OrePrefix.lens, GFTMaterials.Enori)
                .output(GFTItems.GRAPHIC_CHIPSET)
                .duration(300).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipEngraved, Materials.Diamond)
                .input(OrePrefix.wireFine, Materials.RedAlloy, 12)
                .notConsumable(OrePrefix.lens, Materials.Diamond)
                .notConsumable(OrePrefix.lens, GFTMaterials.Restonia)
                .output(GFTItems.LOGIC_CHIPSET)
                .duration(300).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    public static void registerChipsRecipes() {
        addRawChipRecipe(Materials.Amethyst, true);
        addRawChipRecipe(GFTMaterials.Enori, true);
        addRawChipRecipe(Materials.GarnetYellow, true);
        addRawChipRecipe(Materials.Diamond, true);

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipRaw, GFTMaterials.Enori)
                .notConsumable(OrePrefix.lens, GFTMaterials.Enori)
                .output(GFTOrePrefix.chipEngraved, GFTMaterials.Enori)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipRaw, Materials.Amethyst)
                .notConsumable(OrePrefix.craftingLens, Color.Purple)
                .output(GFTOrePrefix.chipEngraved, Materials.Amethyst)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipRaw, Materials.GarnetYellow)
                .notConsumable(OrePrefix.craftingLens, Color.Yellow)
                .output(GFTOrePrefix.chipEngraved, Materials.GarnetYellow)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipRaw, Materials.Diamond)
                .notConsumable(OrePrefix.lens, Materials.Diamond)
                .output(GFTOrePrefix.chipEngraved, Materials.Diamond)
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

    private static void addRawChipRecipe(Material material, boolean doAddHydrogenVersion) {
        if (doAddHydrogenVersion) {
            AUTOCLAVE_RECIPES.recipeBuilder()
                    .input(OrePrefix.gemExquisite, material)
                    .fluidInputs(Materials.Hydrogen.getFluid(1000))
                    .output(GFTOrePrefix.chipRaw, material)
                    .duration(900).EUt(320)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(OrePrefix.gemExquisite, material)
                .fluidInputs(Materials.Argon.getFluid(100))
                .output(GFTOrePrefix.chipRaw, material)
                .duration(800).EUt(280)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private  MachineRecipes() {}
}

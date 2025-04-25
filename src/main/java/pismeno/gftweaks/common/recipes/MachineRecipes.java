package pismeno.gftweaks.common.recipes;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.category.RecipeCategories;
import gregtech.api.recipes.recipeproperties.CleanroomProperty;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.MarkerMaterials.Component;
import gregtech.api.unification.material.MarkerMaterials.Color;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.MetaBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import pismeno.gftweaks.gregtech.GFTMaterials;
import pismeno.gftweaks.gregtech.GFTOrePrefix;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.common.items.MetaItems.*;
import static pismeno.gftweaks.common.GFTItems.*;
import static pismeno.gftweaks.gregtech.GFTRecipeMaps.*;

public class MachineRecipes {
    public static void init() {
        addGeneric();
        registerDecoFabricatorRecipes();
        registerAAFlawlessRecipes();
        registerChipsRecipes();
        registerChipsetRecipes();
        registerCircuits();

    }

    public static void postInit() {
        removeWoodPulpRecyclings();
    }

    private static void addGeneric() {
        addImplosionRecipe(new ItemStack(HEAVY_DUTY_COMPOSITE), new ItemStack(COMPRESSED_HEAVY_DUTY_COMPOSITE), 8);
        addImplosionRecipe(new ItemStack(HEAVY_DUTY_COMPOSITE2), new ItemStack(COMPRESSED_HEAVY_DUTY_COMPOSITE2), 8);
        addImplosionRecipe(OreDictUnifier.get(OrePrefix.dust, GFTMaterials.FluixPearl, 9), getItemStack("appliedenergistics2:material", 9, 1), 8);

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(1024).duration(500)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(POWER_INTEGRATED_CIRCUIT, 4)
                .input(LAPOTRONIC_CHIPSET, 24)
                .input(NANO_CENTRAL_PROCESSING_UNIT, 2)
                .input(OrePrefix.wireFine, Materials.Platinum, 16)
                .input(OrePrefix.plate, Materials.Platinum, 8)
                .output(ENERGY_LAPOTRONIC_ORB)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(600).duration(60)
                .inputs(getItemStack("appliedenergistics2:material", 22, 1))
                .input(OrePrefix.circuit, Tier.EV)
                .input(CENTRAL_CHIPSET)
                .outputs(getItemStack("appliedenergistics2:material", 43, 1))
                .solderMultiplier(1)
                .circuitMeta(1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(600).duration(60)
                .inputs(getItemStack("appliedenergistics2:material", 22, 1))
                .input(OrePrefix.circuit, Tier.EV)
                .input(CENTRAL_CHIPSET)
                .outputs(getItemStack("appliedenergistics2:material", 44, 1))
                .solderMultiplier(1)
                .circuitMeta(32)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();


        MIXER_RECIPES.recipeBuilder()
                .EUt(VA[EV]).duration(500)
                .input(OrePrefix.dust, Materials.EnderPearl)
                .input(OrePrefix.dust, GFTMaterials.Fluix, 8)
                .output(OrePrefix.dust, GFTMaterials.FluixPearl, 9)
                .buildAndRegister();


        MACERATOR_RECIPES.recipeBuilder()
                .EUt(2).duration(18)
                .inputs(getItemStack("appliedenergistics2:material", 7, 1))
                .output(OrePrefix.dust, GFTMaterials.Fluix)
                .category(RecipeCategories.MACERATOR_RECYCLING)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .EUt(2).duration(18)
                .inputs(getItemStack("appliedenergistics2:material", 9, 1))
                .output(OrePrefix.dust, GFTMaterials.FluixPearl, 9)
                .category(RecipeCategories.MACERATOR_RECYCLING)
                .buildAndRegister();


        AUTOCLAVE_RECIPES.recipeBuilder()
                .EUt(VA[HV]).duration(1200)
                .input(OrePrefix.dust,GFTMaterials.Fluix)
                .fluidInputs(Materials.Water.getFluid(250))
                .outputs(getItemStack("appliedenergistics2:material", 7, 1))
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .EUt(VA[HV]).duration(600)
                .input(OrePrefix.dust,GFTMaterials.Fluix)
                .fluidInputs(Materials.DistilledWater.getFluid(50))
                .outputs(getItemStack("appliedenergistics2:material", 7, 1))
                .buildAndRegister();


        COMPRESSOR_RECIPES.recipeBuilder()
                .EUt(VA[EV]).duration(1200)
                .input(HEAVY_DUTY_COMPOSITE3)
                .output(AsteroidsItems.basicItem, 1, 5)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                        .EUt(VA[EV]).duration(400)
                        .inputs(getItemStack("appliedenergistics2:material", 20, 1))
                        .inputs(getItemStack("appliedenergistics2:material", 16, 1))
                        .outputs(getItemStack("appliedenergistics2:material", 23, 1))
                        .cleanroom(CleanroomType.CLEANROOM)
                        .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .EUt(VA[EV]).duration(400)
                .inputs(getItemStack("appliedenergistics2:material", 20, 1))
                .inputs(getItemStack("appliedenergistics2:material", 18, 1))
                .outputs(getItemStack("appliedenergistics2:material", 22, 1))
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .EUt(VA[EV]).duration(400)
                .inputs(getItemStack("appliedenergistics2:material", 20, 1))
                .inputs(getItemStack("appliedenergistics2:material", 17, 1))
                .outputs(getItemStack("appliedenergistics2:material", 24, 1))
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();


        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .EUt(480).duration(1200)
                .input(CENTRAL_PROCESSING_UNIT_WAFER)
                .input(OrePrefix.plate, Materials.Glowstone, 2)
                .input(CARBON_FIBERS, 16)
                .input(OrePrefix.lens, GFTMaterials.Void)
                .output(NANO_CENTRAL_PROCESSING_UNIT_WAFER)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .notConsumable(getItemStack("appliedenergistics2:material", 15, 1))
                .EUt(480).duration(300)
                .input(OrePrefix.plateDouble, Materials.Gold, 2)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.EV)
                .input(LOGIC_CHIPSET)
                .input(APPLICATING_CHIPSET)
                .outputs(getItemStack("appliedenergistics2:material", 18, 1))
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .notConsumable(getItemStack("appliedenergistics2:material", 13, 1))
                .EUt(480).duration(300)
                .input(OrePrefix.plate, Materials.CertusQuartz, 4)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.EV)
                .input(COMPUTING_CHIPSET)
                .input(APPLICATING_CHIPSET)
                .outputs(getItemStack("appliedenergistics2:material", 16, 1))
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .notConsumable(getItemStack("appliedenergistics2:material", 14, 1))
                .EUt(480).duration(300)
                .input(OrePrefix.plate, Materials.Diamond, 4)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.EV)
                .input(CENTRAL_CHIPSET)
                .input(APPLICATING_CHIPSET)
                .outputs(getItemStack("appliedenergistics2:material", 17, 1))
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    public static void registerCircuits() {
        //WORKSTATION
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[MV]).duration(400)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(PROCESSOR_ASSEMBLY_HV, 2)
                .input(OrePrefix.component, Component.Diode, 4)
                .input(RANDOM_ACCESS_MEMORY, 4)
                .input(OrePrefix.wireFine, Materials.Electrum, 16)
                .input(COMPUTING_CHIPSET)
                .output(WORKSTATION_EV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //NANOPROCESSOR
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(600).duration(200)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(NANO_CENTRAL_PROCESSING_UNIT)
                .input(SMD_RESISTOR, 8)
                .input(SMD_CAPACITOR, 8)
                .input(SMD_TRANSISTOR, 8)
                .input(COMPUTING_CHIPSET)
                .output(NANO_PROCESSOR_HV, 2)
                .solderMultiplier(1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(600).duration(100)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(NANO_CENTRAL_PROCESSING_UNIT)
                .input(ADVANCED_SMD_RESISTOR, 2)
                .input(ADVANCED_SMD_CAPACITOR, 2)
                .input(ADVANCED_SMD_TRANSISTOR, 2)
                .input(COMPUTING_CHIPSET)
                .output(NANO_PROCESSOR_HV, 2)
                .solderMultiplier(1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(9600).duration(50)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(ADVANCED_SYSTEM_ON_CHIP)
                .input(NANO_CENTRAL_PROCESSING_UNIT)
                .input(COMPUTING_CHIPSET)
                .input(OrePrefix.bolt, Materials.Platinum, 4)
                .output(NANO_PROCESSOR_HV, 4)
                .solderMultiplier(1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //NANOPROCESSOR ASSEMBLY
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(600).duration(400)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_HV, 2)
                .input(SMD_INDUCTOR, 4)
                .input(SMD_CAPACITOR, 8)
                .input(RANDOM_ACCESS_MEMORY, 8)
                .input(CONTROL_CHIPSET)
                .output(NANO_PROCESSOR_ASSEMBLY_EV)
                .solderMultiplier(1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(600).duration(200)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_HV, 2)
                .input(ADVANCED_SMD_INDUCTOR, 1)
                .input(ADVANCED_SMD_CAPACITOR, 2)
                .input(RANDOM_ACCESS_MEMORY, 8)
                .input(CONTROL_CHIPSET)
                .output(NANO_PROCESSOR_ASSEMBLY_EV)
                .solderMultiplier(1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //MAINFRAME
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(480).duration(800)
                .input(OrePrefix.frameGt, Materials.Aluminium, 2)
                .input(WORKSTATION_EV, 2)
                .input(OrePrefix.component, Component.Inductor, 8)
                .input(OrePrefix.component, Component.Capacitor, 16)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(CONTROL_CHIPSET)
                .output(MAINFRAME_IV)
                .solderMultiplier(4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(480).duration(400)
                .input(OrePrefix.frameGt, Materials.Aluminium, 2)
                .input(WORKSTATION_EV, 2)
                .input(ADVANCED_SMD_INDUCTOR, 2)
                .input(ADVANCED_SMD_CAPACITOR, 4)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(CONTROL_CHIPSET)
                .output(MAINFRAME_IV)
                .solderMultiplier(4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //QUANTUMPROCESSOR
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(2400).duration(200)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(NANO_CENTRAL_PROCESSING_UNIT)
                .input(QUBIT_CENTRAL_PROCESSING_UNIT)
                .input(SMD_CAPACITOR, 12)
                .input(SMD_TRANSISTOR, 12)
                .input(CENTRAL_CHIPSET)
                .output(QUANTUM_PROCESSOR_EV, 2)
                .solderMultiplier(1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(2400).duration(100)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(NANO_CENTRAL_PROCESSING_UNIT)
                .input(QUBIT_CENTRAL_PROCESSING_UNIT)
                .input(ADVANCED_SMD_CAPACITOR, 3)
                .input(ADVANCED_SMD_TRANSISTOR, 3)
                .input(CENTRAL_CHIPSET)
                .output(QUANTUM_PROCESSOR_EV, 2)
                .solderMultiplier(1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(38400).duration(50)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(ADVANCED_SYSTEM_ON_CHIP)
                .input(CENTRAL_CHIPSET)
                .input(OrePrefix.bolt, Materials.NiobiumTitanium, 8)
                .output(QUANTUM_PROCESSOR_EV, 4)
                .solderMultiplier(1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //NANO SUPERCOMPUTER
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(600).duration(400)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_ASSEMBLY_EV, 2)
                .input(SMD_DIODE, 8)
                .input(NOR_MEMORY_CHIP, 4)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(CENTRAL_CHIPSET)
                .output(NANO_COMPUTER_IV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(600).duration(200)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_ASSEMBLY_EV, 2)
                .input(ADVANCED_SMD_DIODE, 2)
                .input(NOR_MEMORY_CHIP, 4)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(CENTRAL_CHIPSET)
                .output(NANO_COMPUTER_IV)
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
                .output(PROCESSING_CHIPSET)
                .duration(250).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipEngraved, GFTMaterials.Enori)
                .input(OrePrefix.wireFine, Materials.BlueAlloy, 12)
                .notConsumable(OrePrefix.lens, GFTMaterials.Enori)
                .notConsumable(OrePrefix.lens, GFTMaterials.Palis)
                .output(COMPUTING_CHIPSET)
                .duration(300).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipEngraved, Materials.Amethyst)
                .input(OrePrefix.wireFine, Materials.Silver, 12)
                .notConsumable(OrePrefix.craftingLens, Color.Purple)
                .notConsumable(OrePrefix.lens, GFTMaterials.Enori)
                .output(GRAPHIC_CHIPSET)
                .duration(300).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipEngraved, Materials.Diamond)
                .input(OrePrefix.wireFine, Materials.RedAlloy, 12)
                .notConsumable(OrePrefix.lens, Materials.Diamond)
                .notConsumable(OrePrefix.lens, GFTMaterials.Restonia)
                .output(LOGIC_CHIPSET)
                .duration(300).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipEngraved, GFTMaterials.Restonia)
                .input(OrePrefix.wireFine, Materials.Platinum, 12)
                .notConsumable(OrePrefix.lens, GFTMaterials.Restonia)
                .notConsumable(OrePrefix.lens, GFTMaterials.Enori)
                .output(CONTROL_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipEngraved, GFTMaterials.Void)
                .input(OrePrefix.wireFine, Materials.Graphene, 12)
                .notConsumable(OrePrefix.lens, GFTMaterials.Void)
                .notConsumable(OrePrefix.craftingLens, Color.Gray)
                .output(CENTRAL_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipEngraved, GFTMaterials.Restonia)
                .input(OrePrefix.wireFine, Materials.RedAlloy, 12)
                .notConsumable(OrePrefix.lens, GFTMaterials.Restonia)
                .notConsumable(OrePrefix.lens, GFTMaterials.Enori)
                .output(APPLICATING_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipEngraved, Materials.Lapotron)
                .input(OrePrefix.wireFine, Materials.Electrum, 12)
                .notConsumable(OrePrefix.lens, Materials.Lapotron)
                .notConsumable(OrePrefix.lens, GFTMaterials.Enori)
                .output(LAPOTRONIC_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    public static void registerChipsRecipes() {
        addRawChipRecipe(Materials.Amethyst, true, 350);
        addRawChipRecipe(GFTMaterials.Enori, true, 350);
        addRawChipRecipe(Materials.GarnetYellow, true, 350);
        addRawChipRecipe(Materials.Diamond, true, 350);
        addRawChipRecipe(GFTMaterials.Restonia, false, 350);
        addRawChipRecipe(GFTMaterials.Void, false, 350);
        addRawChipRecipe(GFTMaterials.Restonia, false, 480);

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(OrePrefix.gem, Materials.Lapotron)
                .fluidInputs(Materials.Argon.getFluid(100))
                .output(GFTOrePrefix.chipRaw, Materials.Lapotron)
                .duration(800).EUt(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();


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

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipRaw, Materials.Diamond)
                .notConsumable(OrePrefix.lens, Materials.Diamond)
                .output(GFTOrePrefix.chipEngraved, Materials.Diamond)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipRaw, GFTMaterials.Restonia)
                .notConsumable(OrePrefix.lens, GFTMaterials.Restonia)
                .output(GFTOrePrefix.chipEngraved, GFTMaterials.Restonia)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipRaw, GFTMaterials.Void)
                .notConsumable(OrePrefix.lens, GFTMaterials.Void)
                .output(GFTOrePrefix.chipEngraved, GFTMaterials.Void)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipRaw, GFTMaterials.Restonia)
                .notConsumable(OrePrefix.lens, GFTMaterials.Restonia)
                .output(GFTOrePrefix.chipEngraved, GFTMaterials.Restonia)
                .duration(400).EUt(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GFTOrePrefix.chipRaw, Materials.Lapotron)
                .notConsumable(OrePrefix.craftingLens, Color.Blue)
                .output(GFTOrePrefix.chipEngraved, Materials.Lapotron)
                .duration(400).EUt(1200)
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

    private static void addRawChipRecipe(Material material, boolean doAddHydrogenVersion, int EUt) {
        if (doAddHydrogenVersion) {
            AUTOCLAVE_RECIPES.recipeBuilder()
                    .input(OrePrefix.gemExquisite, material)
                    .fluidInputs(Materials.Hydrogen.getFluid(1000))
                    .output(GFTOrePrefix.chipRaw, material)
                    .duration(900).EUt(EUt)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(OrePrefix.gemExquisite, material)
                .fluidInputs(Materials.Argon.getFluid(100))
                .output(GFTOrePrefix.chipRaw, material)
                .duration(800).EUt((int) (EUt * 0.8))
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void addImplosionRecipe(ItemStack input, ItemStack output, int explosives) {


        IMPLOSION_RECIPES.recipeBuilder()
                .inputs(input)
                .outputs(output)
                .chancedOutput(OrePrefix.dust, Materials.DarkAsh, 2500, 0)
                .explosivesType(new ItemStack(MetaBlocks.POWDERBARREL, explosives))
                .duration(20).EUt(896)
                .buildAndRegister();

        IMPLOSION_RECIPES.recipeBuilder()
                .inputs(input)
                .outputs(output)
                .chancedOutput(OrePrefix.dust, Materials.DarkAsh, 2500, 0)
                .explosivesAmount(explosives / 2)
                .duration(20).EUt(896)
                .buildAndRegister();

        IMPLOSION_RECIPES.recipeBuilder()
                .inputs(input)
                .outputs(output)
                .chancedOutput(OrePrefix.dust, Materials.DarkAsh, 2500, 0)
                .explosivesType(DYNAMITE.getStackForm(explosives / 4))
                .duration(20).EUt(896)
                .buildAndRegister();

        IMPLOSION_RECIPES.recipeBuilder()
                .inputs(input)
                .outputs(output)
                .chancedOutput(OrePrefix.dust, Materials.DarkAsh, 2500, 0)
                .explosivesType(new ItemStack(MetaBlocks.ITNT))
                .duration(20).EUt(896)
                .buildAndRegister();
    }

    private static ItemStack getItemStack(String registryName, int meta, int count) {
        try {
            ResourceLocation resourceLocation = new ResourceLocation(registryName);
            Item item = ForgeRegistries.ITEMS.getValue(resourceLocation);

            if (item == null) {
                System.err.println("Item not found: " + registryName);
                return ItemStack.EMPTY;
            }

            return new ItemStack(item, count, meta);
        } catch (Exception e) {
            System.err.println("Error creating ItemStack for: " + registryName);
            e.printStackTrace();
            return ItemStack.EMPTY;
        }
    }

    private  MachineRecipes() {}
}

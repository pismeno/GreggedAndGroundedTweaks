package pismeno.gagtweaks.common.recipes;

import betterwithmods.common.BWMItems;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import de.ellpeck.actuallyadditions.mod.items.InitItems;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.category.RecipeCategories;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
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
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import pismeno.gagtweaks.gregtech.GAGOrePrefix;
import pokefenn.totemic.entity.animal.EntityBuffalo;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.ItalianBuffaloMilk;
import static gregtechfoodoption.recipe.GTFORecipeMaps.*;
import static pismeno.gagtweaks.common.GAGItems.*;
import static pismeno.gagtweaks.general.Utils.getItemStack;
import static pismeno.gagtweaks.gregtech.GAGMaterials.*;
import static pismeno.gagtweaks.gregtech.GAGRecipeMaps.*;

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
        addEnhancedGlueRecipes();
        removeWoodPulpRecyclings();
    }

    private static void addGeneric() {
        addImplosionRecipe(new ItemStack(HEAVY_DUTY_COMPOSITE), new ItemStack(COMPRESSED_HEAVY_DUTY_COMPOSITE), 8);
        addImplosionRecipe(new ItemStack(HEAVY_DUTY_COMPOSITE2), new ItemStack(COMPRESSED_HEAVY_DUTY_COMPOSITE2), 8);
        addImplosionRecipe(OreDictUnifier.get(OrePrefix.dust, FluixPearl, 9), getItemStack("appliedenergistics2:material", 9, 1), 8);

        MOB_EXTRACTOR_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(11))
                .mob(EntityBuffalo.class)
                .fluidOutputs(ItalianBuffaloMilk.getFluid(10))
                .EUt(16)
                .duration(20)
                .buildAndRegister();


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
                .input(OrePrefix.dust, Fluix, 8)
                .output(OrePrefix.dust, FluixPearl, 9)
                .buildAndRegister();


        CUTTER_RECIPES.recipeBuilder()
                .EUt(2).duration(40)
                .input(Items.LEATHER)
                .output(BWMItems.MATERIAL, 2, 31)
                .buildAndRegister();


        MACERATOR_RECIPES.recipeBuilder()
                .EUt(2).duration(18)
                .inputs(getItemStack("appliedenergistics2:material", 7, 1))
                .output(OrePrefix.dust, Fluix)
                .category(RecipeCategories.MACERATOR_RECYCLING)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .EUt(2).duration(18)
                .inputs(getItemStack("appliedenergistics2:material", 9, 1))
                .output(OrePrefix.dust, FluixPearl, 9)
                .category(RecipeCategories.MACERATOR_RECYCLING)
                .buildAndRegister();


        AUTOCLAVE_RECIPES.recipeBuilder()
                .EUt(VA[HV]).duration(1200)
                .input(OrePrefix.dust, Fluix)
                .fluidInputs(Materials.Water.getFluid(250))
                .outputs(getItemStack("appliedenergistics2:material", 7, 1))
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .EUt(VA[HV]).duration(600)
                .input(OrePrefix.dust, Fluix)
                .fluidInputs(Materials.DistilledWater.getFluid(50))
                .outputs(getItemStack("appliedenergistics2:material", 7, 1))
                .buildAndRegister();


        COMPRESSOR_RECIPES.recipeBuilder()
                .EUt(VA[EV]).duration(1200)
                .input(HEAVY_DUTY_COMPOSITE3)
                .output(AsteroidsItems.basicItem, 1, 5)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .EUt(VA[EV]).duration(2400)
                .input(HEAVY_DUTY_COMPOSITE4)
                .output(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .EUt(VA[IV]).duration(2400)
                .input(HEAVY_DUTY_COMPOSITE5)
                .output(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .EUt(VA[LuV]).duration(2400)
                .input(HEAVY_DUTY_COMPOSITE6)
                .output(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .EUt(VA[LuV]).duration(2400)
                .input(HEAVY_DUTY_COMPOSITE7)
                .output(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .EUt(VA[ZPM]).duration(2400)
                .input(HEAVY_DUTY_COMPOSITE8)
                .output(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .EUt(VA[ZPM]).duration(2400)
                .input(HEAVY_DUTY_COMPOSITE9)
                .output(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3)
                .buildAndRegister();


        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .EUt(40000).duration(100)
                .input(GAGOrePrefix.chipEngraved, Olivine)
                .input(CRYSTAL_CHIPSET)
                .output(ENGRAVED_CRYSTAL_CHIPSET)
                .cleanroom(CleanroomType.CLEANROOM)
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

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(PECCORITE_CRYSTAL_EMPOWERED, 2)
                .notConsumable(OrePrefix.craftingLens, Color.White)
                .output(OrePrefix.gemFlawless, Peccorite)
                .duration(240).EUt(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NITANITE_CRYSTAL_EMPOWERED, 2)
                .notConsumable(OrePrefix.craftingLens, Color.White)
                .output(OrePrefix.gemFlawless, Nitanite)
                .duration(240).EUt(480)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();


        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .EUt(480).duration(1200)
                .input(CENTRAL_PROCESSING_UNIT_WAFER)
                .input(OrePrefix.plate, Materials.Glowstone, 2)
                .input(CARBON_FIBERS, 16)
                .input(OrePrefix.lens, Void)
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

        //QUANTUMPROCESSOR ASSEMBLY
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(2400).duration(400)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_PROCESSOR_EV, 2)
                .input(SMD_INDUCTOR, 8)
                .input(SMD_CAPACITOR, 16)
                .input(RANDOM_ACCESS_MEMORY, 4)
                .input(ADAPTIVE_CHIPSET)
                .output(QUANTUM_ASSEMBLY_IV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(2400).duration(200)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_PROCESSOR_EV, 2)
                .input(ADVANCED_SMD_INDUCTOR, 2)
                .input(ADVANCED_SMD_CAPACITOR, 4)
                .input(RANDOM_ACCESS_MEMORY, 4)
                .input(ADAPTIVE_CHIPSET)
                .output(QUANTUM_ASSEMBLY_IV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //NANOPROCESSOR MAINFRAME
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(1920).duration(800)
                .input(OrePrefix.frameGt, Materials.Aluminium, 2)
                .input(NANO_COMPUTER_IV, 2)
                .input(SMD_INDUCTOR, 16)
                .input(SMD_CAPACITOR, 32)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(ADAPTIVE_CHIPSET)
                .output(NANO_MAINFRAME_LUV)
                .solderMultiplier(4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(1920).duration(400)
                .input(OrePrefix.frameGt, Materials.Aluminium, 2)
                .input(NANO_COMPUTER_IV, 2)
                .input(ADVANCED_SMD_INDUCTOR, 4)
                .input(ADVANCED_SMD_CAPACITOR, 8)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(ADAPTIVE_CHIPSET)
                .output(NANO_MAINFRAME_LUV)
                .solderMultiplier(4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //QUANTUM SUPERCOMPUTER
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(2400).duration(400)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_ASSEMBLY_IV, 2)
                .input(SMD_DIODE, 8)
                .input(NOR_MEMORY_CHIP, 4)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(ADVANCED_CHIPSET)
                .output(QUANTUM_COMPUTER_LUV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(2400).duration(200)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_ASSEMBLY_IV, 2)
                .input(ADVANCED_SMD_DIODE, 2)
                .input(NOR_MEMORY_CHIP, 4)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(ADVANCED_CHIPSET)
                .output(QUANTUM_COMPUTER_LUV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //QUANTUMPROCESSOR MAINFRAME
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(7680).duration(800)
                .input(OrePrefix.frameGt, Materials.HSSG, 2)
                .input(QUANTUM_COMPUTER_LUV, 2)
                .input(SMD_INDUCTOR, 24)
                .input(SMD_CAPACITOR, 48)
                .input(RANDOM_ACCESS_MEMORY, 24)
                .input(BETTER_CHIPSET)
                .output(QUANTUM_MAINFRAME_ZPM)
                .solderMultiplier(4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(7680).duration(400)
                .input(OrePrefix.frameGt, Materials.HSSG, 2)
                .input(QUANTUM_COMPUTER_LUV, 2)
                .input(ADVANCED_SMD_INDUCTOR, 6)
                .input(ADVANCED_SMD_CAPACITOR, 12)
                .input(RANDOM_ACCESS_MEMORY, 24)
                .input(BETTER_CHIPSET)
                .output(QUANTUM_MAINFRAME_ZPM)
                .solderMultiplier(4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //CRYSTALPROCESSOR ASSEMBLY
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(9600).duration(400)
                .input(ELITE_CIRCUIT_BOARD)
                .input(CRYSTAL_PROCESSOR_IV, 2)
                .input(ADVANCED_SMD_INDUCTOR, 4)
                .input(ADVANCED_SMD_CAPACITOR, 8)
                .input(RANDOM_ACCESS_MEMORY, 24)
                .input(BETTER_CHIPSET)
                .output(CRYSTAL_ASSEMBLY_LUV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //CRYSTALPROCESSOR
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(9600).duration(200)
                .input(ELITE_CIRCUIT_BOARD)
                .input(CRYSTAL_CHIPSET)
                .input(ADVANCED_CHIPSET)
                .input(NANO_CENTRAL_PROCESSING_UNIT, 2)
                .input(ADVANCED_SMD_CAPACITOR, 6)
                .input(ADVANCED_SMD_TRANSISTOR, 6)
                .output(CRYSTAL_PROCESSOR_IV, 2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(86000).duration(100)
                .input(ELITE_CIRCUIT_BOARD)
                .input(ENGRAVED_CRYSTAL_CHIPSET)
                .input(ADVANCED_CHIPSET)
                .input(bolt, YttriumBariumCuprate, 8)
                .output(CRYSTAL_PROCESSOR_IV, 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //CRYSTAL SUPERCOMPUTER
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(9600).duration(400)
                .input(ELITE_CIRCUIT_BOARD)
                .input(CRYSTAL_ASSEMBLY_LUV, 2)
                .input(RANDOM_ACCESS_MEMORY, 4)
                .input(NOR_MEMORY_CHIP, 32)
                .input(NAND_MEMORY_CHIP, 64)
                .input(EXPERT_CHIPSET)
                .solderMultiplier(2)
                .output(CRYSTAL_COMPUTER_ZPM)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //CRYSTALPROCESSOR MAINFRAME
        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(VA[LuV]).duration(800)
                .input(frameGt, HSSE, 2)
                .input(CRYSTAL_COMPUTER_ZPM, 2)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(wireGtSingle, NiobiumTitanium, 8)
                .input(ADVANCED_SMD_INDUCTOR, 8)
                .input(ADVANCED_SMD_CAPACITOR, 16)
                .input(ADVANCED_SMD_DIODE, 8)
                .input(ELITE_CHIPSET)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .output(CRYSTAL_MAINFRAME_UV)
                .stationResearch(b -> b
                        .researchStack(CRYSTAL_COMPUTER_ZPM.getStackForm())
                        .CWUt(16))
                .buildAndRegister();

        //DATA MODULE
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(WETWARE_CIRCUIT_BOARD)
                .input(circuit, Tier.ZPM, 2)
                .input(ELITE_CHIPSET, 2)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(NOR_MEMORY_CHIP, 64)
                .input(NAND_MEMORY_CHIP, 64)
                .output(TOOL_DATA_MODULE)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .duration(400).EUt(38400).buildAndRegister();
    }

    public static void registerChipsetRecipes() {
        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Materials.GarnetYellow)
                .input(OrePrefix.wireFine, Materials.RedAlloy, 12)
                .notConsumable(OrePrefix.craftingLens, Color.Yellow)
                .notConsumable(OrePrefix.lens, Restonia)
                .output(PROCESSING_CHIPSET)
                .duration(250).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Enori)
                .input(OrePrefix.wireFine, Materials.BlueAlloy, 12)
                .notConsumable(OrePrefix.lens, Enori)
                .notConsumable(OrePrefix.lens, Palis)
                .output(COMPUTING_CHIPSET)
                .duration(300).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Materials.Amethyst)
                .input(OrePrefix.wireFine, Materials.Silver, 12)
                .notConsumable(OrePrefix.craftingLens, Color.Purple)
                .notConsumable(OrePrefix.lens, Enori)
                .output(GRAPHIC_CHIPSET)
                .duration(300).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Materials.Diamond)
                .input(OrePrefix.wireFine, Materials.RedAlloy, 12)
                .notConsumable(OrePrefix.lens, Materials.Diamond)
                .notConsumable(OrePrefix.lens, Restonia)
                .output(LOGIC_CHIPSET)
                .duration(300).EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Restonia)
                .input(OrePrefix.wireFine, Materials.Platinum, 12)
                .notConsumable(OrePrefix.lens, Restonia)
                .notConsumable(OrePrefix.lens, Enori)
                .output(CONTROL_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Void)
                .input(OrePrefix.wireFine, Materials.Graphene, 12)
                .notConsumable(OrePrefix.lens, Void)
                .notConsumable(OrePrefix.craftingLens, Color.Gray)
                .output(CENTRAL_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Restonia)
                .input(OrePrefix.wireFine, Materials.RedAlloy, 12)
                .notConsumable(OrePrefix.lens, Restonia)
                .notConsumable(OrePrefix.lens, Enori)
                .output(APPLICATING_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Materials.Lapotron)
                .input(OrePrefix.wireFine, Materials.Electrum, 12)
                .notConsumable(OrePrefix.craftingLens, Color.Blue)
                .notConsumable(OrePrefix.lens, Enori)
                .output(LAPOTRONIC_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Palis)
                .input(OrePrefix.wireFine, Materials.Platinum, 12)
                .notConsumable(OrePrefix.lens, Palis)
                .notConsumable(OrePrefix.lens, Enori)
                .output(ADAPTIVE_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Peccorite)
                .input(OrePrefix.wireFine, Materials.NiobiumTitanium, 12)
                .notConsumable(OrePrefix.lens, Peccorite)
                .notConsumable(OrePrefix.lens, Void)
                .output(ADVANCED_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Diamatine)
                .input(OrePrefix.wireFine, Materials.NiobiumTitanium, 12)
                .notConsumable(OrePrefix.lens, Diamatine)
                .notConsumable(OrePrefix.lens, Void)
                .output(BETTER_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Emeradic)
                .input(OrePrefix.wireFine, Materials.YttriumBariumCuprate, 12)
                .notConsumable(OrePrefix.lens, Emeradic)
                .notConsumable(OrePrefix.lens, Void)
                .output(EXPERT_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Nitanite)
                .input(OrePrefix.wireFine, Materials.YttriumBariumCuprate, 12)
                .notConsumable(OrePrefix.lens, Nitanite)
                .notConsumable(OrePrefix.lens, Void)
                .output(ELITE_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_FABRICATOR_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipEngraved, Materials.Olivine)
                .input(OrePrefix.wireFine, Materials.NiobiumTitanium, 12)
                .notConsumable(OrePrefix.lens, Emeradic)
                .notConsumable(OrePrefix.lens, Void)
                .output(CRYSTAL_CHIPSET)
                .duration(300).EUt(VA[EV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    public static void registerChipsRecipes() {
        addRawChipRecipe(Materials.Amethyst, 0, 350);
        addRawChipRecipe(Enori, 0, 350);
        addRawChipRecipe(Materials.GarnetYellow, 0, 350);
        addRawChipRecipe(Materials.Diamond, 0, 350);
        addRawChipRecipe(Restonia, 1, 350);
        addRawChipRecipe(Void, 1, 350);
        addRawChipRecipe(Restonia, 1, 480);
        addRawChipRecipe(Palis, 1, 1200);
        addRawChipRecipe(Peccorite, 1, 1200);
        addRawChipRecipe(Diamatine, 1, 6000);
        addRawChipRecipe(Emeradic, 2, 10000);
        addRawChipRecipe(Nitanite, 2, 10000);
        addRawChipRecipe(Materials.Olivine, 2, 10000);

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(OrePrefix.gem, Materials.Lapotron)
                .fluidInputs(Materials.Argon.getFluid(100))
                .output(GAGOrePrefix.chipRaw, Materials.Lapotron)
                .duration(800).EUt(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();


        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Enori)
                .notConsumable(OrePrefix.lens, Enori)
                .output(GAGOrePrefix.chipEngraved, Enori)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Materials.Amethyst)
                .notConsumable(OrePrefix.craftingLens, Color.Purple)
                .output(GAGOrePrefix.chipEngraved, Materials.Amethyst)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Materials.GarnetYellow)
                .notConsumable(OrePrefix.craftingLens, Color.Yellow)
                .output(GAGOrePrefix.chipEngraved, Materials.GarnetYellow)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Materials.Diamond)
                .notConsumable(OrePrefix.lens, Materials.Diamond)
                .output(GAGOrePrefix.chipEngraved, Materials.Diamond)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Materials.Diamond)
                .notConsumable(OrePrefix.lens, Materials.Diamond)
                .output(GAGOrePrefix.chipEngraved, Materials.Diamond)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Restonia)
                .notConsumable(OrePrefix.lens, Restonia)
                .output(GAGOrePrefix.chipEngraved, Restonia)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Void)
                .notConsumable(OrePrefix.lens, Void)
                .output(GAGOrePrefix.chipEngraved, Void)
                .duration(400).EUt(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Restonia)
                .notConsumable(OrePrefix.lens, Restonia)
                .output(GAGOrePrefix.chipEngraved, Restonia)
                .duration(400).EUt(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Materials.Lapotron)
                .notConsumable(OrePrefix.craftingLens, Color.Blue)
                .output(GAGOrePrefix.chipEngraved, Materials.Lapotron)
                .duration(400).EUt(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Palis)
                .notConsumable(OrePrefix.lens, Palis)
                .output(GAGOrePrefix.chipEngraved, Palis)
                .duration(400).EUt(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Peccorite)
                .notConsumable(OrePrefix.lens, Peccorite)
                .output(GAGOrePrefix.chipEngraved, Peccorite)
                .duration(400).EUt(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Nitanite)
                .notConsumable(OrePrefix.lens, Nitanite)
                .output(GAGOrePrefix.chipEngraved, Nitanite)
                .duration(400).EUt(6000)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Emeradic)
                .notConsumable(OrePrefix.lens, Emeradic)
                .output(GAGOrePrefix.chipEngraved, Emeradic)
                .duration(400).EUt(6000)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Materials.Olivine)
                .notConsumable(OrePrefix.craftingLens, Emeradic)
                .output(GAGOrePrefix.chipEngraved, Materials.Olivine)
                .duration(400).EUt(6000)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(GAGOrePrefix.chipRaw, Diamatine)
                .notConsumable(OrePrefix.lens, Diamatine)
                .output(GAGOrePrefix.chipEngraved, Diamatine)
                .duration(400).EUt(6000)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    public static void registerAAFlawlessRecipes() {
        int i = 0;
        for (Material material : AAMaterials) {
            LASER_ENGRAVER_RECIPES.recipeBuilder()
                    .inputs(new ItemStack(InitItems.itemCrystalEmpowered, 2, i))
                    .notConsumable(OrePrefix.craftingLens, Color.White)
                    .output(OrePrefix.gemFlawless, material)
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

    private static void removeGeneric() {
        //MOB_EXTRACTOR_RECIPES.findRecipe().remove();
    }

    private static void addEnhancedGlueRecipes() {
        for (Recipe recipe : ASSEMBLER_RECIPES.getRecipeList()) {
            if (!recipe.getIsCTRecipe() && !recipe.isGroovyRecipe()) {
                for (GTRecipeInput input : recipe.getFluidInputs()) {
                    FluidStack fluidInput = input.getInputFluidStack();
                    if (fluidInput.getFluid() == Glue.getFluid()) {
                        ASSEMBLER_RECIPES.recipeBuilder()
                                .duration((int) (recipe.getDuration() * 0.8F)).EUt(recipe.getEUt())
                                .inputs(recipe.getInputs().toArray(new GTRecipeInput[0]))
                                .outputs(recipe.getOutputs())
                                .fluidInputs(new FluidStack(EnhancedGlue.getFluid(), fluidInput.amount / 2))
                                .buildAndRegister();
                    }
                }
            }
        }
    }

    private static void addRawChipRecipe(Material material, int fluidTier, int EUt) {
        if (fluidTier < 1) {
            AUTOCLAVE_RECIPES.recipeBuilder()
                    .input(OrePrefix.gemExquisite, material)
                    .fluidInputs(Materials.Hydrogen.getFluid(1000))
                    .output(GAGOrePrefix.chipRaw, material)
                    .duration(900).EUt(EUt)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }

        if (fluidTier < 2) {
            AUTOCLAVE_RECIPES.recipeBuilder()
                    .input(OrePrefix.gemExquisite, material)
                    .fluidInputs(Materials.Argon.getFluid(100))
                    .output(GAGOrePrefix.chipRaw, material)
                    .duration(800).EUt((int) (EUt * 0.8))
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }

        if (fluidTier < 3) {
            AUTOCLAVE_RECIPES.recipeBuilder()
                    .input(OrePrefix.gemExquisite, material)
                    .fluidInputs(Materials.Europium.getFluid(16))
                    .output(GAGOrePrefix.chipRaw, material)
                    .duration(700).EUt((int) (EUt * 0.6))
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }
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

    private  MachineRecipes() {}
}

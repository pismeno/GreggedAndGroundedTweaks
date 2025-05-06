package pismeno.gagtweaks.common.recipes;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static pismeno.gagtweaks.gregtech.GAGMaterials.*;

public class AtmosphereRecipes {
    public static void init() {
        initCollection();
        initVacuum();
        initDistillation();
    }

    private static void initCollection() {
        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .fluidOutputs(MarsAtmosphere.getFluid(10000))
                .dimension(-29)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .fluidOutputs(MoonAtmosphere.getFluid(10000))
                .dimension(-28)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .fluidOutputs(VenusAtmosphere.getFluid(10000))
                .dimension(-31)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .fluidOutputs(PhobosAtmosphere.getFluid(10000))
                .dimension(-1502)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .fluidOutputs(DeimosAtmosphere.getFluid(10000))
                .dimension(-1503)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(9)
                .fluidOutputs(IoAtmosphere.getFluid(10000))
                .dimension(-1500)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(10)
                .fluidOutputs(EuropaAtmosphere.getFluid(10000))
                .dimension(-1501)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(11)
                .fluidOutputs(GanymedeAtmosphere.getFluid(10000))
                .dimension(-1506)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(12)
                .fluidOutputs(CallistoAtmosphere.getFluid(10000))
                .dimension(-1505)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(13)
                .fluidOutputs(TritonAtmosphere.getFluid(10000))
                .dimension(-1504)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(14)
                .fluidOutputs(RheaAtmosphere.getFluid(10000))
                .dimension(-1507)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(15)
                .fluidOutputs(TitanAtmosphere.getFluid(10000))
                .dimension(-1508)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .fluidOutputs(OberonAtmosphere.getFluid(10000))
                .dimension(-1509)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(17)
                .fluidOutputs(TitaniaAtmosphere.getFluid(10000))
                .dimension(-1510)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .fluidOutputs(IapetusAtmosphere.getFluid(10000))
                .dimension(-1511)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(19)
                .fluidOutputs(PlutoAtmosphere.getFluid(10000))
                .dimension(-19)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(20)
                .fluidOutputs(CeresAtmosphere.getFluid(10000))
                .dimension(-20)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(21)
                .fluidOutputs(Kepler22bAtmosphere.getFluid(10000))
                .dimension(-22)
                .duration(200).EUt(VA[HV]).buildAndRegister();
    }

    private static void initDistillation() {
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidMoonAtmosphere.getFluid(200000))
                .fluidOutputs(Helium.getFluid(150000))
                .fluidOutputs(Hydrogen.getFluid(30000))
                .fluidOutputs(Neon.getFluid(10000))
                .fluidOutputs(Argon.getFluid(5000))
                .fluidOutputs(Nitrogen.getFluid(5000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidMarsAtmosphere.getFluid(200000))
                .fluidOutputs(CarbonDioxide.getFluid(190000))
                .fluidOutputs(Nitrogen.getFluid(10000))
                .fluidOutputs(Argon.getFluid(300))
                .fluidOutputs(Oxygen.getFluid(200))
                .fluidOutputs(CarbonMonoxide.getFluid(200))
                .fluidOutputs(Neon.getFluid(100))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidVenusAtmosphere.getFluid(200000))
                .fluidOutputs(CarbonDioxide.getFluid(192000))
                .fluidOutputs(Nitrogen.getFluid(6000))
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .fluidOutputs(Water.getFluid(500))
                .fluidOutputs(Argon.getFluid(300))
                .fluidOutputs(Neon.getFluid(200))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidSaturnAtmosphere.getFluid(200000))
                .fluidOutputs(Hydrogen.getFluid(188000))
                .fluidOutputs(Helium.getFluid(10000))
                .fluidOutputs(Methane.getFluid(1000))
                .fluidOutputs(Ethane.getFluid(500))
                .fluidOutputs(Ammonia.getFluid(300))
                .fluidOutputs(Neon.getFluid(200))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidUranusAtmosphere.getFluid(200000))
                .fluidOutputs(Hydrogen.getFluid(182000))
                .fluidOutputs(Helium.getFluid(15000))
                .fluidOutputs(Methane.getFluid(2000))
                .fluidOutputs(Ammonia.getFluid(500))
                .fluidOutputs(Argon.getFluid(300))
                .fluidOutputs(Neon.getFluid(200))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidNeptuneAtmosphere.getFluid(200000))
                .fluidOutputs(Hydrogen.getFluid(180000))
                .fluidOutputs(Helium.getFluid(15000))
                .fluidOutputs(Methane.getFluid(3000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .fluidOutputs(Krypton.getFluid(500))
                .fluidOutputs(Neon.getFluid(500))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidMercuryAtmosphere.getFluid(200000))
                .fluidOutputs(Oxygen.getFluid(130000))
                .fluidOutputs(Nitrogen.getFluid(30000))
                .fluidOutputs(Hydrogen.getFluid(20000))
                .fluidOutputs(Helium.getFluid(10000))
                .fluidOutputs(Argon.getFluid(5000))
                .fluidOutputs(Neon.getFluid(5000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidJupiterAtmosphere.getFluid(200000))
                .fluidOutputs(Hydrogen.getFluid(175000))
                .fluidOutputs(Helium.getFluid(20000))
                .fluidOutputs(Methane.getFluid(3000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .fluidOutputs(Neon.getFluid(500))
                .fluidOutputs(Krypton.getFluid(500))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidPlutoAtmosphere.getFluid(200000))
                .fluidOutputs(Nitrogen.getFluid(170000))
                .fluidOutputs(Methane.getFluid(20000))
                .fluidOutputs(CarbonMonoxide.getFluid(8000))
                .fluidOutputs(Neon.getFluid(1000))
                .fluidOutputs(Argon.getFluid(1000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidEuropaAtmosphere.getFluid(200000))
                .fluidOutputs(Oxygen.getFluid(180000))
                .fluidOutputs(Water.getFluid(15000))
                .fluidOutputs(Hydrogen.getFluid(3000))
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .fluidOutputs(Neon.getFluid(1000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidCallistoAtmosphere.getFluid(200000))
                .fluidOutputs(CarbonDioxide.getFluid(180000))
                .fluidOutputs(Oxygen.getFluid(15000))
                .fluidOutputs(SulfurDioxide.getFluid(3000))
                .fluidOutputs(Argon.getFluid(1000))
                .fluidOutputs(Neon.getFluid(1000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidGanymedeAtmosphere.getFluid(200000))
                .fluidOutputs(Oxygen.getFluid(190000))
                .fluidOutputs(Hydrogen.getFluid(5000))
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .fluidOutputs(Neon.getFluid(1000))
                .fluidOutputs(Argon.getFluid(2000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidIoAtmosphere.getFluid(200000))
                .fluidOutputs(SulfurDioxide.getFluid(180000))
                .fluidOutputs(SulfurTrioxide.getFluid(10000))
                .fluidOutputs(Oxygen.getFluid(5000))
                .fluidOutputs(Argon.getFluid(3000))
                .fluidOutputs(Neon.getFluid(2000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidCeresAtmosphere.getFluid(200000))
                .fluidOutputs(Water.getFluid(180000))
                .fluidOutputs(Hydrogen.getFluid(10000))
                .fluidOutputs(Oxygen.getFluid(8000))
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidDeimosAtmosphere.getFluid(200000))
                .fluidOutputs(CarbonDioxide.getFluid(170000))
                .fluidOutputs(Nitrogen.getFluid(15000))
                .fluidOutputs(Argon.getFluid(10000))
                .fluidOutputs(Oxygen.getFluid(3000))
                .fluidOutputs(Neon.getFluid(2000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidErisAtmosphere.getFluid(200000))
                .fluidOutputs(Methane.getFluid(150000))
                .fluidOutputs(Nitrogen.getFluid(30000))
                .fluidOutputs(CarbonMonoxide.getFluid(10000))
                .fluidOutputs(Neon.getFluid(5000))
                .fluidOutputs(Argon.getFluid(5000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidIapetusAtmosphere.getFluid(200000))
                .fluidOutputs(CarbonDioxide.getFluid(160000))
                .fluidOutputs(Methane.getFluid(20000))
                .fluidOutputs(Nitrogen.getFluid(10000))
                .fluidOutputs(Ethane.getFluid(5000))
                .fluidOutputs(Neon.getFluid(5000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidKepler22bAtmosphere.getFluid(200000))
                .fluidOutputs(Nitrogen.getFluid(160000))
                .fluidOutputs(Oxygen.getFluid(30000))
                .fluidOutputs(Argon.getFluid(5000))
                .fluidOutputs(CarbonDioxide.getFluid(3000))
                .fluidOutputs(Methane.getFluid(2000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidOberonAtmosphere.getFluid(200000))
                .fluidOutputs(Hydrogen.getFluid(160000))
                .fluidOutputs(Methane.getFluid(25000))
                .fluidOutputs(Helium.getFluid(10000))
                .fluidOutputs(Neon.getFluid(5000))
                .fluidOutputs(Argon.getFluid(5000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidPhobosAtmosphere.getFluid(200000))
                .fluidOutputs(CarbonDioxide.getFluid(150000))
                .fluidOutputs(Nitrogen.getFluid(30000))
                .fluidOutputs(Oxygen.getFluid(10000))
                .fluidOutputs(Neon.getFluid(5000))
                .fluidOutputs(Argon.getFluid(5000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidRheaAtmosphere.getFluid(200000))
                .fluidOutputs(Oxygen.getFluid(180000))
                .fluidOutputs(CarbonDioxide.getFluid(10000))
                .fluidOutputs(Hydrogen.getFluid(5000))
                .fluidOutputs(Neon.getFluid(3000))
                .fluidOutputs(Argon.getFluid(2000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidTitanAtmosphere.getFluid(200000))
                .fluidOutputs(Nitrogen.getFluid(180000))
                .fluidOutputs(Methane.getFluid(10000))
                .fluidOutputs(Hydrogen.getFluid(5000))
                .fluidOutputs(Argon.getFluid(3000))
                .fluidOutputs(Neon.getFluid(2000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidTitaniaAtmosphere.getFluid(200000))
                .fluidOutputs(Oxygen.getFluid(160000))
                .fluidOutputs(CarbonDioxide.getFluid(20000))
                .fluidOutputs(Hydrogen.getFluid(10000))
                .fluidOutputs(Neon.getFluid(5000))
                .fluidOutputs(Argon.getFluid(5000))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidTritonAtmosphere.getFluid(200000))
                .fluidOutputs(Nitrogen.getFluid(170000))
                .fluidOutputs(Methane.getFluid(20000))
                .fluidOutputs(CarbonMonoxide.getFluid(5000))
                .fluidOutputs(Argon.getFluid(2500))
                .fluidOutputs(Neon.getFluid(2500))
                .disableDistilleryRecipes()
                .duration(2000).EUt(VA[IV]).buildAndRegister();
    }

    private static void initVacuum() {
        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(MoonAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidMoonAtmosphere.getFluid(4000))
                .duration(61).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(MarsAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidMarsAtmosphere.getFluid(4000))
                .duration(58).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(VenusAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidVenusAtmosphere.getFluid(4000))
                .duration(231).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(SaturnAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidSaturnAtmosphere.getFluid(4000))
                .duration(48).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(UranusAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidUranusAtmosphere.getFluid(4000))
                .duration(43).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(NeptuneAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidNeptuneAtmosphere.getFluid(4000))
                .duration(40).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(MercuryAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidMercuryAtmosphere.getFluid(4000))
                .duration(80).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(JupiterAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidJupiterAtmosphere.getFluid(4000))
                .duration(53).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(PlutoAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidPlutoAtmosphere.getFluid(4000))
                .duration(41).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(CallistoAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidCallistoAtmosphere.getFluid(4000))
                .duration(40).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(GanymedeAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidGanymedeAtmosphere.getFluid(4000))
                .duration(40).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(IoAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidIoAtmosphere.getFluid(4000))
                .duration(42).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(CeresAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidCeresAtmosphere.getFluid(4000))
                .duration(42).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(DeimosAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidDeimosAtmosphere.getFluid(4000))
                .duration(44).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(ErisAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidErisAtmosphere.getFluid(4000))
                .duration(42).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(EuropaAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidEuropaAtmosphere.getFluid(4000))
                .duration(40).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(IapetusAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidIapetusAtmosphere.getFluid(4000))
                .duration(45).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(Kepler22bAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidKepler22bAtmosphere.getFluid(4000))
                .duration(147).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(OberonAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidOberonAtmosphere.getFluid(4000))
                .duration(40).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(PhobosAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidPhobosAtmosphere.getFluid(4000))
                .duration(40).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(RheaAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidRheaAtmosphere.getFluid(4000))
                .duration(49).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(TitanAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidTitanAtmosphere.getFluid(4000))
                .duration(47).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(TitaniaAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidTitaniaAtmosphere.getFluid(4000))
                .duration(40).EUt(VA[IV]).buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(TritonAtmosphere.getFluid(4000))
                .fluidOutputs(LiquidTritonAtmosphere.getFluid(4000))
                .duration(40).EUt(VA[IV]).buildAndRegister();
    }
}

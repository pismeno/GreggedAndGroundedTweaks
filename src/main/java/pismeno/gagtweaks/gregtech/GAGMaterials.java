package pismeno.gagtweaks.gregtech;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.util.ResourceLocation;
import pismeno.gagtweaks.Tags;

import java.util.*;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static pismeno.gagtweaks.gregtech.GAGMaterialFlags.*;
import static pismeno.gregstinkering.unification.GTCGregtechMaterials.*;

public class GAGMaterials {

    public static Material MoonAtmosphere;
    public static Material LiquidMoonAtmosphere;
    public static Material MarsAtmosphere;
    public static Material LiquidMarsAtmosphere;
    public static Material VenusAtmosphere;
    public static Material LiquidVenusAtmosphere;
    public static Material SaturnAtmosphere;
    public static Material LiquidSaturnAtmosphere;
    public static Material UranusAtmosphere;
    public static Material LiquidUranusAtmosphere;
    public static Material NeptuneAtmosphere;
    public static Material LiquidNeptuneAtmosphere;
    public static Material MercuryAtmosphere;
    public static Material LiquidMercuryAtmosphere;
    public static Material JupiterAtmosphere;
    public static Material LiquidJupiterAtmosphere;
    public static Material PlutoAtmosphere;
    public static Material LiquidPlutoAtmosphere;
    public static Material CallistoAtmosphere;
    public static Material LiquidCallistoAtmosphere;
    public static Material GanymedeAtmosphere;
    public static Material LiquidGanymedeAtmosphere;
    public static Material IoAtmosphere;
    public static Material LiquidIoAtmosphere;
    public static Material CeresAtmosphere;
    public static Material LiquidCeresAtmosphere;
    public static Material DeimosAtmosphere;
    public static Material LiquidDeimosAtmosphere;
    public static Material ErisAtmosphere;
    public static Material LiquidErisAtmosphere;
    public static Material EuropaAtmosphere;
    public static Material LiquidEuropaAtmosphere;
    public static Material IapetusAtmosphere;
    public static Material LiquidIapetusAtmosphere;
    public static Material Kepler22bAtmosphere;
    public static Material LiquidKepler22bAtmosphere;
    public static Material OberonAtmosphere;
    public static Material LiquidOberonAtmosphere;
    public static Material PhobosAtmosphere;
    public static Material LiquidPhobosAtmosphere;
    public static Material RheaAtmosphere;
    public static Material LiquidRheaAtmosphere;
    public static Material TitanAtmosphere;
    public static Material LiquidTitanAtmosphere;
    public static Material TitaniaAtmosphere;
    public static Material LiquidTitaniaAtmosphere;
    public static Material TritonAtmosphere;
    public static Material LiquidTritonAtmosphere;


    public static Material EnhancedGlue;
    public static Material Wyrmwood;
    public static Material MenrilWood;
    public static Material Enori;
    public static Material Diamatine;
    public static Material Emeradic;
    public static Material Palis;
    public static Material Restonia;
    public static Material Void;
    public static Material CornFlour;
    public static Material RiceFlour;
    public static Material QuartzBlack;
    public static Material Inconel;
    public static Material Kemacite;
    public static Material Taenite;
    public static Material Cobardite;
    public static Material Fluix;
    public static Material FluixPearl;
    public static Material Lunarite;
    public static Material Peccorite;
    public static Material Nitanite;
    public static Material MeteoricIron;
    public static Material Tiamant;

    public static final List<Material> AAMaterials = new ArrayList<>();

    private static final Map<Material, OrePrefix[]> ignoredItems = new HashMap<>();

    public static void init() {
        MoonAtmosphere = new Material.Builder(31000, new ResourceLocation(Tags.MODID, "moon_atmosphere"))
                .gas()
                .color(0xAAAAAA)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        LiquidMoonAtmosphere = new Material.Builder(31001, new ResourceLocation(Tags.MODID, "liquid_moon_atmosphere"))
                .liquid(new FluidBuilder().temperature(100))
                .color(0xAAAAAA)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        MarsAtmosphere = new Material.Builder(31002, new ResourceLocation(Tags.MODID, "mars_atmosphere"))
                .gas()
                .color(0xB04040)
                .flags(DISABLE_DECOMPOSITION)
                .components(CarbonDioxide, 95, Nitrogen, 3, Argon, 2)
                .build();

        LiquidMarsAtmosphere = new Material.Builder(31003, new ResourceLocation(Tags.MODID, "liquid_mars_atmosphere"))
                .liquid(new FluidBuilder().temperature(210))
                .color(0xB04040)
                .flags(DISABLE_DECOMPOSITION)
                .components(CarbonDioxide, 95, Nitrogen, 3, Argon, 2)
                .build();

        VenusAtmosphere = new Material.Builder(31004, new ResourceLocation(Tags.MODID, "venus_atmosphere"))
                .gas()
                .color(0xE07070)
                .flags(DISABLE_DECOMPOSITION)
                .components(CarbonDioxide, 96, Nitrogen, 3, SulfurDioxide, 1)
                .build();

        LiquidVenusAtmosphere = new Material.Builder(31005, new ResourceLocation(Tags.MODID, "liquid_venus_atmosphere"))
                .liquid(new FluidBuilder().temperature(737))
                .color(0xE07070)
                .flags(DISABLE_DECOMPOSITION)
                .components(CarbonDioxide, 96, Nitrogen, 3, SulfurDioxide, 1)
                .build();

        SaturnAtmosphere = new Material.Builder(31006, new ResourceLocation(Tags.MODID, "saturn_atmosphere"))
                .gas()
                .color(0xC0C080)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 96, Helium, 4)
                .build();

        LiquidSaturnAtmosphere = new Material.Builder(31007, new ResourceLocation(Tags.MODID, "liquid_saturn_atmosphere"))
                .liquid(new FluidBuilder().temperature(134))
                .color(0xC0C080)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 96, Helium, 4)
                .build();

        UranusAtmosphere = new Material.Builder(31008, new ResourceLocation(Tags.MODID, "uranus_atmosphere"))
                .gas()
                .color(0x80C0C0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 83, Helium, 15, Methane, 2)
                .build();

        LiquidUranusAtmosphere = new Material.Builder(31009, new ResourceLocation(Tags.MODID, "liquid_uranus_atmosphere"))
                .liquid(new FluidBuilder().temperature(76))
                .color(0x80C0C0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 83, Helium, 15, Methane, 2)
                .build();

        NeptuneAtmosphere = new Material.Builder(31010, new ResourceLocation(Tags.MODID, "neptune_atmosphere"))
                .gas()
                .color(0x6080E0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 80, Helium, 19, Methane, 1)
                .build();

        LiquidNeptuneAtmosphere = new Material.Builder(31011, new ResourceLocation(Tags.MODID, "liquid_neptune_atmosphere"))
                .liquid(new FluidBuilder().temperature(72))
                .color(0x6080E0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 80, Helium, 19, Methane, 1)
                .build();

        MercuryAtmosphere = new Material.Builder(31012, new ResourceLocation(Tags.MODID, "mercury_atmosphere"))
                .gas()
                .color(0xCCCCCC)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        LiquidMercuryAtmosphere = new Material.Builder(31013, new ResourceLocation(Tags.MODID, "liquid_mercury_atmosphere"))
                .liquid(new FluidBuilder().temperature(440))
                .color(0xCCCCCC)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        JupiterAtmosphere = new Material.Builder(31014, new ResourceLocation(Tags.MODID, "jupiter_atmosphere"))
                .gas()
                .color(0xFFD700)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 90, Helium, 10)
                .build();

        LiquidJupiterAtmosphere = new Material.Builder(31015, new ResourceLocation(Tags.MODID, "liquid_jupiter_atmosphere"))
                .liquid(new FluidBuilder().temperature(165))
                .color(0xFFD700)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 90, Helium, 10)
                .build();

        PlutoAtmosphere = new Material.Builder(31016, new ResourceLocation(Tags.MODID, "pluto_atmosphere"))
                .gas()
                .color(0x8888FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 97, Methane, 2, CarbonMonoxide, 1)
                .build();

        LiquidPlutoAtmosphere = new Material.Builder(31017, new ResourceLocation(Tags.MODID, "liquid_pluto_atmosphere"))
                .liquid(new FluidBuilder().temperature(44))
                .color(0x8888FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 97, Methane, 2, CarbonMonoxide, 1)
                .build();

        CallistoAtmosphere = new Material.Builder(31018, new ResourceLocation(Tags.MODID, "callisto_atmosphere"))
                .gas()
                .color(0x666699)
                .flags(DISABLE_DECOMPOSITION)
                .components(CarbonDioxide, 100)
                .build();

        LiquidCallistoAtmosphere = new Material.Builder(31019, new ResourceLocation(Tags.MODID, "liquid_callisto_atmosphere"))
                .liquid(new FluidBuilder().temperature(134))
                .color(0x666699)
                .flags(DISABLE_DECOMPOSITION)
                .components(CarbonDioxide, 100)
                .build();

        GanymedeAtmosphere = new Material.Builder(31020, new ResourceLocation(Tags.MODID, "ganymede_atmosphere"))
                .gas()
                .color(0x6699AA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Oxygen, 100)
                .build();

        LiquidGanymedeAtmosphere = new Material.Builder(31021, new ResourceLocation(Tags.MODID, "liquid_ganymede_atmosphere"))
                .liquid(new FluidBuilder().temperature(110))
                .color(0x6699AA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Oxygen, 100)
                .build();

        IoAtmosphere = new Material.Builder(31022, new ResourceLocation(Tags.MODID, "io_atmosphere"))
                .gas()
                .color(0xFFCC99)
                .flags(DISABLE_DECOMPOSITION)
                .components(SulfurDioxide, 100)
                .build();

        LiquidIoAtmosphere = new Material.Builder(31023, new ResourceLocation(Tags.MODID, "liquid_io_atmosphere"))
                .liquid(new FluidBuilder().temperature(130))
                .color(0xFFCC99)
                .flags(DISABLE_DECOMPOSITION)
                .components(SulfurDioxide, 100)
                .build();

        CeresAtmosphere = new Material.Builder(31024, new ResourceLocation(Tags.MODID, "ceres_atmosphere"))
                .gas()
                .color(0x888866)
                .flags(DISABLE_DECOMPOSITION)
                .components(Water, 100)
                .build();

        LiquidCeresAtmosphere = new Material.Builder(31025, new ResourceLocation(Tags.MODID, "liquid_ceres_atmosphere"))
                .liquid(new FluidBuilder().temperature(167))
                .color(0x888866)
                .flags(DISABLE_DECOMPOSITION)
                .components(Water, 100)
                .build();

        DeimosAtmosphere = new Material.Builder(31026, new ResourceLocation(Tags.MODID, "deimos_atmosphere"))
                .gas()
                .color(0xAAAAAA)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        LiquidDeimosAtmosphere = new Material.Builder(31027, new ResourceLocation(Tags.MODID, "liquid_deimos_atmosphere"))
                .liquid(new FluidBuilder().temperature(233))
                .color(0xAAAAAA)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        ErisAtmosphere = new Material.Builder(31028, new ResourceLocation(Tags.MODID, "eris_atmosphere"))
                .gas()
                .color(0x9999FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Methane, 100)
                .build();

        LiquidErisAtmosphere = new Material.Builder(31029, new ResourceLocation(Tags.MODID, "liquid_eris_atmosphere"))
                .liquid(new FluidBuilder().temperature(30))
                .color(0x9999FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Methane, 100)
                .build();

        EuropaAtmosphere = new Material.Builder(31030, new ResourceLocation(Tags.MODID, "europa_atmosphere"))
                .gas()
                .color(0x9999CC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Oxygen, 100)
                .build();

        LiquidEuropaAtmosphere = new Material.Builder(31031, new ResourceLocation(Tags.MODID, "liquid_europa_atmosphere"))
                .liquid(new FluidBuilder().temperature(102))
                .color(0x9999CC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Oxygen, 100)
                .build();

        IapetusAtmosphere = new Material.Builder(31032, new ResourceLocation(Tags.MODID, "iapetus_atmosphere"))
                .gas()
                .color(0x886655)
                .flags(DISABLE_DECOMPOSITION)
                .components(CarbonDioxide, 100)
                .build();

        LiquidIapetusAtmosphere = new Material.Builder(31033, new ResourceLocation(Tags.MODID, "liquid_iapetus_atmosphere"))
                .liquid(new FluidBuilder().temperature(90))
                .color(0x886655)
                .flags(DISABLE_DECOMPOSITION)
                .components(CarbonDioxide, 100)
                .build();

        Kepler22bAtmosphere = new Material.Builder(31034, new ResourceLocation(Tags.MODID, "keplertwotwob_atmosphere"))
                .gas()
                .color(0x339999)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 78, Oxygen, 21, CarbonDioxide, 1)
                .build();

        LiquidKepler22bAtmosphere = new Material.Builder(31035, new ResourceLocation(Tags.MODID, "liquid_keplertwotwob_atmosphere"))
                .liquid(new FluidBuilder().temperature(295))
                .color(0x339999)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 78, Oxygen, 21, CarbonDioxide, 1)
                .build();

        OberonAtmosphere = new Material.Builder(31036, new ResourceLocation(Tags.MODID, "oberon_atmosphere"))
                .gas()
                .color(0x556688)
                .flags(DISABLE_DECOMPOSITION)
                .components(CarbonDioxide, 100)
                .build();

        LiquidOberonAtmosphere = new Material.Builder(31037, new ResourceLocation(Tags.MODID, "liquid_oberon_atmosphere"))
                .liquid(new FluidBuilder().temperature(76))
                .color(0x556688)
                .flags(DISABLE_DECOMPOSITION)
                .components(CarbonDioxide, 100)
                .build();

        PhobosAtmosphere = new Material.Builder(31038, new ResourceLocation(Tags.MODID, "phobos_atmosphere"))
                .gas()
                .color(0xAAAAAA)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        LiquidPhobosAtmosphere = new Material.Builder(31039, new ResourceLocation(Tags.MODID, "liquid_phobos_atmosphere"))
                .liquid(new FluidBuilder().temperature(233))
                .color(0xAAAAAA)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        RheaAtmosphere = new Material.Builder(31040, new ResourceLocation(Tags.MODID, "rhea_atmosphere"))
                .gas()
                .color(0x77AABB)
                .flags(DISABLE_DECOMPOSITION)
                .components(Oxygen, 70, CarbonDioxide, 30)
                .build();

        LiquidRheaAtmosphere = new Material.Builder(31041, new ResourceLocation(Tags.MODID, "liquid_rhea_atmosphere"))
                .liquid(new FluidBuilder().temperature(99))
                .color(0x77AABB)
                .flags(DISABLE_DECOMPOSITION)
                .components(Oxygen, 70, CarbonDioxide, 30)
                .build();

        TitanAtmosphere = new Material.Builder(31042, new ResourceLocation(Tags.MODID, "titan_atmosphere"))
                .gas()
                .color(0xFF8800)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 95, Methane, 5)
                .build();

        LiquidTitanAtmosphere = new Material.Builder(31043, new ResourceLocation(Tags.MODID, "liquid_titan_atmosphere"))
                .liquid(new FluidBuilder().temperature(94))
                .color(0xFF8800)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 95, Methane, 5)
                .build();

        TitaniaAtmosphere = new Material.Builder(31044, new ResourceLocation(Tags.MODID, "titania_atmosphere"))
                .gas()
                .color(0x9966CC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Oxygen, 100)
                .build();

        LiquidTitaniaAtmosphere = new Material.Builder(31045, new ResourceLocation(Tags.MODID, "liquid_titania_atmosphere"))
                .liquid(new FluidBuilder().temperature(70))
                .color(0x9966CC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Oxygen, 100)
                .build();

        TritonAtmosphere = new Material.Builder(31046, new ResourceLocation(Tags.MODID, "triton_atmosphere"))
                .gas()
                .color(0x6699FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 99, Methane, 1)
                .build();

        LiquidTritonAtmosphere = new Material.Builder(31047, new ResourceLocation(Tags.MODID, "liquid_triton_atmosphere"))
                .liquid(new FluidBuilder().temperature(38))
                .color(0x6699FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 99, Methane, 1)
                .build();



        EnhancedGlue = new Material.Builder(32000, new ResourceLocation(Tags.MODID,"enhanced_glue"))
                .fluid()
                .color(0xFCBC65).flags(STICKY).build();

        MenrilWood = new Material.Builder(32001, new ResourceLocation(Tags.MODID, "menril_wood"))
                .dust(1)
                .color(0x5C728A).iconSet(FINE)
                .flags(GENERATE_PLATE, GENERATE_ROD, NO_SMELTING, FLAMMABLE)
                .build();

        Wyrmwood = new Material.Builder(32002, new ResourceLocation(Tags.MODID, "wyrmwood"))
                .dust(3)
                .color(0x82335e).iconSet(FINE)
                .flags(GENERATE_PLATE, GENERATE_ROD, NO_SMELTING, FLAMMABLE)
                .build();

        Enori = new Material.Builder(32003, new ResourceLocation(Tags.MODID, "enori"))
                .gem()
                .color(0xfefffa).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        Diamatine = new Material.Builder(32004, new ResourceLocation(Tags.MODID, "diamatine"))
                .gem()
                .color(0x6861ed).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, GENERATE_BOLT_SCREW,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        Emeradic = new Material.Builder(32005, new ResourceLocation(Tags.MODID, "emeradic"))
                .gem()
                .color(0x15bf20).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        Palis = new Material.Builder(32006, new ResourceLocation(Tags.MODID, "palis"))
                .gem()
                .color(0x1911b8).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        Restonia = new Material.Builder(32007, new ResourceLocation(Tags.MODID, "restonia"))
                .gem()
                .color(0xe60202).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        Void = new Material.Builder(32008, new ResourceLocation(Tags.MODID, "void"))
                .gem()
                .color(0xe000000).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        CornFlour = new Material.Builder(32009, new ResourceLocation(Tags.MODID, "corn_flour"))
                .dust()
                .color(0xd6bf0d).iconSet(FINE)
                .build();

        QuartzBlack = new Material.Builder(32010, new ResourceLocation(Tags.MODID, "quartz_black"))
                .gem()
                .ore()
                .color(0x121212).iconSet(QUARTZ)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, NO_SMELTING, GENERATE_CHIPS)
                .build();

        Inconel = new Material.Builder(32011, new ResourceLocation(Tags.MODID, "inconel"))
                .ingot()
                .color(0xa0a6a8).iconSet(METALLIC)
                .flags(GENERATE_PLATE, EXCLUDE_PLATE_COMPRESSOR_RECIPE, NO_SMELTING, GENERATE_DOUBLE_PLATE)
                .blast(b -> b.temp(2537, BlastProperty.GasTier.LOW).blastStats(VA[HV], 1700))
                .components(Nickel, 6, Chrome, 2, Cobalt, 1, Molybdenum, 1)
                .build();

        Kemacite = new Material.Builder(32012, new ResourceLocation(Tags.MODID, "kemacite"))
                .dust(1).ore()
                .color(0xC0C0C0).iconSet(METALLIC)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, DECOMPOSITION_BY_CENTRIFUGING)
                .addOreByproducts(Cobalt)
                .oreSmeltInto(Iron)
                .components(Iron, 9, Nickel, 1)
                .build();

        Taenite = new Material.Builder(32013, new ResourceLocation(Tags.MODID, "taenite"))
                .dust(1).ore()
                .color(0xA9A9A9).iconSet(METALLIC)
                .flags(NO_SMELTING, DECOMPOSITION_BY_ELECTROLYZING, DECOMPOSITION_BY_CENTRIFUGING)
                .addOreByproducts(Cobalt)
                .components(Iron, 1, Nickel, 1)
                .build();

        Cobardite = new Material.Builder(32014, new ResourceLocation(Tags.MODID, "cobardite"))
                .dust(1).ore()
                .color(0x714CD1).iconSet(METALLIC)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, DECOMPOSITION_BY_CENTRIFUGING)
                .addOreByproducts(Iron)
                .components(Cobalt, 3, Ardite, 1)
                .build();

        Fluix = new Material.Builder(32015, new ResourceLocation(Tags.MODID, "fluix"))
                .dust()
                .color(0x6050AA).iconSet(CERTUS)
                .components(CertusQuartz, 2, Manyullyn, 1, Amethyst, 1)
                .build();

        FluixPearl = new Material.Builder(32016, new ResourceLocation(Tags.MODID, "fluix_pearl"))
                .dust()
                .color(0x7949b8).iconSet(SHINY)
                .components(Fluix, 8, EnderPearl, 1)
                .build();

        Lunarite = new Material.Builder(32017, new ResourceLocation(Tags.MODID, "lunarite"))
                .gem().ore()
                .color(0x0618B2).iconSet(GEM_VERTICAL)
                .flags()
                .components(Sapphire, 1)
                .build();

        Peccorite = new Material.Builder(32018, new ResourceLocation(Tags.MODID, "peccorite"))
                .gem()
                .color(0xF64E00).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        Nitanite = new Material.Builder(32019, new ResourceLocation(Tags.MODID, "nitanite"))
                .gem()
                .color(0x9B37B4).iconSet(DIAMOND)
                .flags(GENERATE_PLATE, GENERATE_ROD, EXCLUDE_PLATE_COMPRESSOR_RECIPE, GENERATE_LENS, GENERATE_CHIPS,
                        NO_SMASHING, NO_SMELTING, NO_WORKING,
                        EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        MeteoricIron = new Material.Builder(32020, new ResourceLocation(Tags.MODID, "meteoric_iron"))
                .ingot()
                .color(0x8B7E70).iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE)
                .build();

        RiceFlour = new Material.Builder(32021, new ResourceLocation(Tags.MODID, "rice_flour"))
                .dust()
                .color(0xCEC8B0).iconSet(FINE)
                .build();

        Tiamant = new Material.Builder(32022, new ResourceLocation(Tags.MODID, "tiamant"))
                .gem()
                .ore()
                .color(0x0778F2).iconSet(DIAMOND)
                .flags(NO_SMELTING, GENERATE_CHIPS, GENERATE_PLATE)
                .build();

        AAMaterials.addAll(Arrays.asList(Restonia, Palis, Diamatine, Void, Emeradic, Enori));

        ignoredItems.put(Enori, new OrePrefix[]{gem, block});
        ignoredItems.put(Diamatine, new OrePrefix[]{gem, block});
        ignoredItems.put(Emeradic, new OrePrefix[]{gem, block});
        ignoredItems.put(Palis, new OrePrefix[]{gem, block});
        ignoredItems.put(Restonia, new OrePrefix[]{gem, block});
        ignoredItems.put(Void, new OrePrefix[]{gem, block});
        ignoredItems.put(Peccorite, new OrePrefix[]{gem, block});
        ignoredItems.put(Nitanite, new OrePrefix[]{gem, block});
        ignoredItems.put(Fluix, new OrePrefix[]{block});
        ignoredItems.put(Lunarite, new OrePrefix[]{gem});
        ignoredItems.put(MeteoricIron, new OrePrefix[]{ingot, block});
        ignoredItems.put(Electrotine, new OrePrefix[]{dust, ingot});

        for (Map.Entry<Material, OrePrefix[]> entry : ignoredItems.entrySet()) {
            Material material = entry.getKey();
            OrePrefix[] prefixes = entry.getValue();

            for (OrePrefix prefix : prefixes) {
                prefix.setIgnored(material);
            }
        }
    }
}

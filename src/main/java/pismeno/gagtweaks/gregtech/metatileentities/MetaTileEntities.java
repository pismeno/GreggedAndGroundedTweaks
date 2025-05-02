package pismeno.gagtweaks.gregtech.metatileentities;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import net.minecraft.util.ResourceLocation;
import pismeno.gagtweaks.Tags;
import pismeno.gagtweaks.client.GAGTextures;
import pismeno.gagtweaks.gregtech.GAGRecipeMaps;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;


public class MetaTileEntities {
    public static final SimpleMachineMetaTileEntity[] SAW = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];

    public static SteamSaw STEAM_SAW_BRONZE;
    public static SteamSaw STEAM_SAW_STEEL;
    public static LaserFabricator LASER_FABRICATOR;

    public static MEInputBus ME_INPUT_BUS;
    public static MEOutputBus ME_OUTPUT_BUS;
    public static MEInputHatch ME_INPUT_HATCH;
    public static MEOutputHatch ME_OUTPUT_HATCH;
    public static MEStockingBus ME_STOCKING_BUS;
    public static MEStockingHatch ME_STOCKING_HATCH;

    private MetaTileEntities() {}

    public static void init() {
        STEAM_SAW_BRONZE = registerMetaTileEntity(11000, new SteamSaw(new ResourceLocation(Tags.MODID, "steam_saw_bronze"), false));
        STEAM_SAW_STEEL = registerMetaTileEntity(11001, new SteamSaw(new ResourceLocation(Tags.MODID, "steam_saw_steel"), true));

        registerSimpleMetaTileEntity(SAW, 11002, "saw", GAGRecipeMaps.SAW_RECIPES,
                GAGTextures.SAW_OVERLAY, true, machineName -> new ResourceLocation(Tags.MODID, machineName)  , fluidTank -> 0);

        LASER_FABRICATOR = registerMetaTileEntity(11011,
                new LaserFabricator(new ResourceLocation(Tags.MODID, "laser_fabricator")));

        ME_INPUT_BUS = registerMetaTileEntity(11012, new MEInputBus(new ResourceLocation(Tags.MODID, "me_input_bus")));
        ME_OUTPUT_BUS = registerMetaTileEntity(11013, new MEOutputBus(new ResourceLocation(Tags.MODID, "me_output_bus")));
        ME_INPUT_HATCH = registerMetaTileEntity(11014, new MEInputHatch(new ResourceLocation(Tags.MODID, "me_input_hatch")));
        ME_OUTPUT_HATCH = registerMetaTileEntity(11015, new MEOutputHatch(new ResourceLocation(Tags.MODID, "me_output_hatch")));
        ME_STOCKING_BUS = registerMetaTileEntity(11016, new MEStockingBus(new ResourceLocation(Tags.MODID, "me_stocking_bus")));
        ME_STOCKING_HATCH = registerMetaTileEntity(11017, new MEStockingHatch(new ResourceLocation(Tags.MODID, "me_stocking_hatch")));
    }
}

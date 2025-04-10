package pismeno.gftweaks.gregtech.metatileentities;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import net.minecraft.util.ResourceLocation;
import pismeno.gftweaks.Tags;
import pismeno.gftweaks.client.GFTTextures;
import pismeno.gftweaks.gregtech.GFTRecipeMaps;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static gregtech.common.metatileentities.MetaTileEntities.registerSimpleMetaTileEntity;


public class MetaTileEntities {
    public static final SimpleMachineMetaTileEntity[] SAW = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];

    public static SteamSaw STEAM_SAW_BRONZE;
    public static SteamSaw STEAM_SAW_STEEL;
    public static LaserFabricator LASER_FABRICATOR;

    private MetaTileEntities() {}

    public static void init() {
        STEAM_SAW_BRONZE = registerMetaTileEntity(11000, new SteamSaw(new ResourceLocation(Tags.MODID, "steam_saw_bronze"), false));
        STEAM_SAW_STEEL = registerMetaTileEntity(11001, new SteamSaw(new ResourceLocation(Tags.MODID, "steam_saw_steel"), true));

        registerSimpleMetaTileEntity(SAW, 11002, "saw", GFTRecipeMaps.SAW_RECIPES,
                GFTTextures.SAW_OVERLAY, true, machineName -> new ResourceLocation(Tags.MODID, machineName)  , fluidTank -> 0);

        LASER_FABRICATOR = registerMetaTileEntity(11011,
                new LaserFabricator(new ResourceLocation(Tags.MODID, "laser_fabricator")));
    }
}

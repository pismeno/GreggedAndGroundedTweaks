package pismeno.gftweaks.gregtech.metatileentities;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.common.metatileentities.multi.multiblockpart.appeng.MetaTileEntityMEInputBus;
import net.minecraft.util.ResourceLocation;

public class MEInputBus extends MetaTileEntityMEInputBus {

    public MEInputBus(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTValues.IV);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MEInputBus(metaTileEntityId);
    }
}

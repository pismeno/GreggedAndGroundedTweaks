package pismeno.gagtweaks.gregtech.metatileentities;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.common.metatileentities.multi.multiblockpart.appeng.MetaTileEntityMEInputHatch;
import net.minecraft.util.ResourceLocation;

public class MEInputHatch extends MetaTileEntityMEInputHatch {

    public MEInputHatch(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTValues.IV);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MEInputHatch(metaTileEntityId);
    }
}

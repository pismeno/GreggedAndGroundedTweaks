package pismeno.gftweaks.gregtech.metatileentities;

import gregtech.api.capability.impl.NotifiableItemStackHandler;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SteamMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.particle.VanillaParticleEffects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;
import pismeno.gftweaks.client.GFTGuiTextures;
import pismeno.gftweaks.client.GFTTextures;
import pismeno.gftweaks.gregtech.GFTRecipeMaps;

public class SteamSaw extends SteamMetaTileEntity {

    public SteamSaw(ResourceLocation metaTileEntityId, boolean isHighPressure) {
        super(metaTileEntityId, GFTRecipeMaps.SAW_RECIPES, GFTTextures.SAW_OVERLAY, isHighPressure);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new SteamSaw(metaTileEntityId, isHighPressure);
    }

    @Override
    protected IItemHandlerModifiable createImportItemHandler() {
        return new NotifiableItemStackHandler(this, 1, this, false);
    }

    @Override
    protected IItemHandlerModifiable createExportItemHandler() {
        return new NotifiableItemStackHandler(this, 1, this, true);
    }

    @Override
    public ModularUI createUI(EntityPlayer player) {
        return createUITemplate(player)
                .slot(this.importItems, 0, 53, 25, GuiTextures.SLOT_STEAM.get(isHighPressure),
                        GFTGuiTextures.SAW_OVERLAY_STEAM.get(isHighPressure))
                .progressBar(workableHandler::getProgressPercent, 79, 25, 20, 18,
                        GFTGuiTextures.PROGRESS_BAR_SAW_STEAM.get(isHighPressure), MoveType.HORIZONTAL,
                        workableHandler.getRecipeMap())
                .slot(this.exportItems, 0, 107, 25, true, false, GuiTextures.SLOT_STEAM.get(isHighPressure))
                .build(getHolder(), player);
    }

    @Override
    public int getItemOutputLimit() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick() {
        if (isActive()) {
            VanillaParticleEffects.defaultFrontEffect(this, EnumParticleTypes.CLOUD);
        }
    }
}

package pismeno.gftweaks.gregtech.metatileentities;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.core.sound.GTSoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import pismeno.gftweaks.client.GFTTextures;
import pismeno.gftweaks.gregtech.GFTRecipeMaps;
import slimeknights.tconstruct.shared.TinkerCommons;


public class LaserFabricator extends RecipeMapMultiblockController {

    public LaserFabricator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GFTRecipeMaps.LASER_FABRICATOR_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new LaserFabricator(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "TTT", "XXX", "XXX")
                .aisle("XXX", "T#T", "XXX", "XXX")
                .aisle("XSX", "TTT", "XXX", "XXX")
                .where('S', selfPredicate())
                .where('X', states(MetaBlocks.METAL_CASING.getState(MetalCasingType.STAINLESS_CLEAN)).or(autoAbilities()))
                .where('T', states(TinkerCommons.blockClearGlass.getDefaultState()))
                .where('#', air())
                .build();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return gregtech.client.renderer.texture.Textures.CLEAN_STAINLESS_STEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GFTTextures.LASER_FABRICATOR_OVERLAY;
    }

    @Override
    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_MECHANICAL;
    }
}

package pismeno.gagtweaks.mixins.late;

import com.google.common.base.Predicate;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicPhobos;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(
        value = {BlockBasicPhobos.class},
        remap = false
)
public class MixinBlockBasicPhobos {
    @Shadow @Final public static PropertyEnum<BlockBasicPhobos.EnumBlockBasic> BASIC_TYPE;

    /**
     * @author PismenoK
     * @reason Need to generate ores there.
     */
    @Overwrite
    public boolean isReplaceableOreGen(IBlockState state, IBlockAccess world, BlockPos pos, Predicate<IBlockState> target) {
        BlockBasicPhobos.EnumBlockBasic type = state.getValue(BASIC_TYPE);
        return type == BlockBasicPhobos.EnumBlockBasic.STONE;
    }
}
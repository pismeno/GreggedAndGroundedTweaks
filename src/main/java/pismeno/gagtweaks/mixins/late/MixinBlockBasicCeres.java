package pismeno.gagtweaks.mixins.late;

import com.google.common.base.Predicate;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicCeres;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(
        value = {BlockBasicCeres.class},
        remap = false
)
public class MixinBlockBasicCeres {
    @Shadow @Final public static PropertyEnum<BlockBasicCeres.EnumBlockBasic> BASIC_TYPE;

    /**
     * @author PismenoK
     * @reason Need to generate ores there.
     */
    @Overwrite
    public boolean isReplaceableOreGen(IBlockState state, IBlockAccess world, BlockPos pos, Predicate<IBlockState> target) {
        BlockBasicCeres.EnumBlockBasic type = state.getValue(BASIC_TYPE);
        return type == BlockBasicCeres.EnumBlockBasic.STONE;
    }
}
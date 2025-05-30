package pismeno.gagtweaks.actuallyadditions;

import de.ellpeck.actuallyadditions.mod.blocks.BlockDisplayStand;
import de.ellpeck.actuallyadditions.mod.util.ItemUtil;
import de.ellpeck.actuallyadditions.mod.util.StackUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GAGBlockDisplayStand extends BlockDisplayStand {
    public GAGBlockDisplayStand(String name) {
        super(name);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new GAGTileEntityDisplayStand();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing par6, float par7, float par8, float par9) {
        ItemStack heldItem = player.getHeldItem(hand);
        if (!world.isRemote) {
            GAGTileEntityDisplayStand stand = (GAGTileEntityDisplayStand) world.getTileEntity(pos);
            if (stand != null) {
                ItemStack display = stand.inv.getStackInSlot(0);
                if (StackUtil.isValid(heldItem)) {
                    if (!StackUtil.isValid(display)) {
                        ItemStack toPut = heldItem.copy();
                        toPut.setCount(1);
                        stand.inv.setStackInSlot(0, toPut);
                        if (!player.capabilities.isCreativeMode) heldItem.shrink(1);
                        return true;
                    } else if (ItemUtil.canBeStacked(heldItem, display)) {
                        int maxTransfer = Math.min(display.getCount(), heldItem.getMaxStackSize() - heldItem.getCount());
                        if (maxTransfer > 0) {
                            heldItem.grow(maxTransfer);
                            ItemStack newDisplay = display.copy();
                            newDisplay.shrink(maxTransfer);
                            stand.inv.setStackInSlot(0, newDisplay);
                            return true;
                        }
                    }
                } else {
                    if (StackUtil.isValid(display)) {
                        player.setHeldItem(hand, display.copy());
                        stand.inv.setStackInSlot(0, StackUtil.getEmpty());
                        return true;
                    }
                }
            }
            return false;
        } else {
            return true;
        }
    }
}

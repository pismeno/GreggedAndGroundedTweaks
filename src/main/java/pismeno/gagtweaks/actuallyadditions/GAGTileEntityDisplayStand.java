package pismeno.gagtweaks.actuallyadditions;

import de.ellpeck.actuallyadditions.api.misc.IDisplayStandItem;
import de.ellpeck.actuallyadditions.mod.tile.CustomEnergyStorage;
import de.ellpeck.actuallyadditions.mod.tile.TileEntityBase;
import de.ellpeck.actuallyadditions.mod.tile.TileEntityDisplayStand;
import de.ellpeck.actuallyadditions.mod.util.StackUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.energy.IEnergyStorage;

public class GAGTileEntityDisplayStand extends TileEntityDisplayStand {

    public final CustomEnergyStorage storage = new CustomEnergyStorage(800000, 1966080, 0);
    private int oldEnergy;

    public GAGTileEntityDisplayStand() {
        super();
    }


    @Override
    public CustomEnergyStorage getEnergyStorage() {
        return this.storage;
    }

    @Override
    public IEnergyStorage getEnergyStorage(EnumFacing facing) {
        return this.storage;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (!this.world.isRemote) {
            if (StackUtil.isValid(this.inv.getStackInSlot(0)) && !this.isRedstonePowered) {
                IDisplayStandItem item = this.convertToDisplayStandItem(this.inv.getStackInSlot(0).getItem());
                if (item != null) {
                    int energy = item.getUsePerTick(this.inv.getStackInSlot(0), this, this.ticksElapsed);
                    if (this.storage.getEnergyStored() >= energy) {
                        if (item.update(this.inv.getStackInSlot(0), this, this.ticksElapsed)) {
                            this.storage.extractEnergyInternal(energy, false);
                        }
                    }
                }
            }

            if (this.oldEnergy != this.storage.getEnergyStored() && this.sendUpdateWithInterval()) {
                this.oldEnergy = this.storage.getEnergyStored();
            }
        }
    }

    private IDisplayStandItem convertToDisplayStandItem(Item item) {
        if (item instanceof IDisplayStandItem) {
            return (IDisplayStandItem) item;
        } else if (item instanceof ItemBlock) {
            Block block = Block.getBlockFromItem(item);
            if (block instanceof IDisplayStandItem) { return (IDisplayStandItem) block; }
        }
        return null;
    }

    @Override
    public void writeSyncableNBT(NBTTagCompound compound, TileEntityBase.NBTType type) {
        super.writeSyncableNBT(compound, type);
        this.storage.writeToNBT(compound);
    }

    @Override
    public void readSyncableNBT(NBTTagCompound compound, TileEntityBase.NBTType type) {
        super.readSyncableNBT(compound, type);
        this.storage.readFromNBT(compound);
    }
}

package pismeno.gagtweaks.actuallyadditions;

import de.ellpeck.actuallyadditions.api.ActuallyAdditionsAPI;
import de.ellpeck.actuallyadditions.api.recipe.EmpowererRecipe;
import de.ellpeck.actuallyadditions.mod.tile.TileEntityEmpowerer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;

public class GAGTileEntityEmpowerer extends TileEntityEmpowerer {
    public int processTime;
    public int recipeForRenderIndex = -1;
    private int lastRecipe;

    public GAGTileEntityEmpowerer() {
        super();
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (!this.world.isRemote) {
            GAGTileEntityDisplayStand[] stands = this.getNearbyStands();
            if (stands != null) {
                EmpowererRecipe recipe = findMatchingRecipe(this.inv.getStackInSlot(0), stands[0].getStack(), stands[1].getStack(), stands[2].getStack(), stands[3].getStack());
                if (recipe != null) {
                    this.recipeForRenderIndex = ActuallyAdditionsAPI.EMPOWERER_RECIPES.indexOf(recipe);

                    boolean hasPower = true;

                    for (GAGTileEntityDisplayStand stand : stands) {
                        if (stand.storage.getEnergyStored() < recipe.getEnergyPerStand() / recipe.getTime()) hasPower = false;
                    }

                    if (hasPower) {

                        this.processTime++;
                        boolean done = this.processTime >= recipe.getTime();

                        for (GAGTileEntityDisplayStand stand : stands) {
                            stand.storage.extractEnergyInternal(recipe.getEnergyPerStand() / recipe.getTime(), false);

                            if (done) {
                                stand.inv.getStackInSlot(0).shrink(1);
                                stand.markDirty();
                            }
                        }

                        if (this.processTime % 5 == 0 && this.world instanceof WorldServer) {
                            ((WorldServer) this.world).spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, false, this.pos.getX() + 0.5, this.pos.getY() + 1.1, this.pos.getZ() + 0.5, 2, 0, 0, 0, 0.1D);
                        }

                        if (done) {
                            ((WorldServer) this.world).spawnParticle(EnumParticleTypes.END_ROD, false, this.pos.getX() + 0.5, this.pos.getY() + 1.1, this.pos.getZ() + 0.5, 100, 0, 0, 0, 0.25D);

                            this.inv.setStackInSlot(0, recipe.getOutput().copy());
                            this.markDirty();

                            this.processTime = 0;
                            this.recipeForRenderIndex = -1;
                        }
                    }
                } else {
                    this.processTime = 0;
                    this.recipeForRenderIndex = -1;
                }

                if (this.lastRecipe != this.recipeForRenderIndex) {
                    this.lastRecipe = this.recipeForRenderIndex;
                    this.sendUpdate();
                }
            }
        }
    }

    private GAGTileEntityDisplayStand[] getNearbyStands() {
        GAGTileEntityDisplayStand[] stands = new GAGTileEntityDisplayStand[4];

        for (int i = 0; i < EnumFacing.HORIZONTALS.length; i++) {
            EnumFacing facing = EnumFacing.HORIZONTALS[i];
            BlockPos offset = this.pos.offset(facing, 3);
            TileEntity tile = this.world.getTileEntity(offset);
            if (tile instanceof GAGTileEntityDisplayStand) stands[i] = (GAGTileEntityDisplayStand) tile;
            else return null;
        }

        return stands;
    }
}

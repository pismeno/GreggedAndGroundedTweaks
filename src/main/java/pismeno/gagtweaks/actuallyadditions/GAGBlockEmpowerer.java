package pismeno.gagtweaks.actuallyadditions;

import de.ellpeck.actuallyadditions.mod.blocks.BlockEmpowerer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GAGBlockEmpowerer extends BlockEmpowerer {
    public GAGBlockEmpowerer(String name) {
        super(name);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new GAGTileEntityEmpowerer();
    }
}

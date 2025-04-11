package pismeno.gftweaks.common.blocks;

import gregtech.api.items.toolitem.ToolClasses;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import pismeno.gftweaks.Tags;

import static pismeno.gftweaks.common.GFTBlocks.BLOCKS;

public class BlockCasing extends Block {
    public BlockCasing(String name) {
        super(Material.ROCK, MapColor.GRAY);
        setRegistryName(Tags.MODID, name);
        setTranslationKey(Tags.MODID + "." + name);
        setHardness(4.0f);
        setResistance(8.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);

        BLOCKS.add(this);
    }
}

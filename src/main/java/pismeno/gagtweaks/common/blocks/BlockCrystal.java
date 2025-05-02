package pismeno.gagtweaks.common.blocks;

import gregtech.api.items.toolitem.ToolClasses;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import pismeno.gagtweaks.Tags;

import static pismeno.gagtweaks.common.GAGBlocks.BLOCKS;

public class BlockCrystal extends Block {
    public BlockCrystal(String name) {
        super(Material.ROCK, MapColor.GRAY);
        setRegistryName(Tags.MODID, name);
        setTranslationKey(Tags.MODID + "." + name);
        setHardness(1.5f);
        setResistance(10.0f);
        setHarvestLevel(ToolClasses.PICKAXE, 1);

        BLOCKS.add(this);
    }
}

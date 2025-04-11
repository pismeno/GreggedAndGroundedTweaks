package pismeno.gftweaks.common;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import pismeno.gftweaks.GfTweaks;
import pismeno.gftweaks.Tags;
import pismeno.gftweaks.common.blocks.BlockCasing;

import java.util.ArrayList;
import java.util.List;

public class GFTBlocks {
    public static List<Block> BLOCKS = new ArrayList<>();

    public static Block CARBON_MACHINE_CASING;
    public static Block CARBON_MACHINE_HULL;

    public static void init() {
        CARBON_MACHINE_CASING = new BlockCasing("carbon_machine_casing");
        CARBON_MACHINE_HULL = new BlockCasing("carbon_machine_hull");
    }

    public static void registerModels() {
        for (Block block : BLOCKS) {
            ModelLoader.setCustomModelResourceLocation(
                    Item.getItemFromBlock(block), 0,
                    new ModelResourceLocation(block.getRegistryName(), "inventory")
            );
            GfTweaks.LOGGER.info("Register model for " + block.getRegistryName());
        }
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event){
        for (Block block : BLOCKS) {
            event.getRegistry().register(block);
            GfTweaks.LOGGER.info("Register block for " + block.getRegistryName());
        }
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Block block : BLOCKS) {
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
            GfTweaks.LOGGER.info("Register item for " + block.getRegistryName());
        }
    }
}

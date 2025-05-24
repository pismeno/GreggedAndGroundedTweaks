package pismeno.gagtweaks.common;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import pismeno.gagtweaks.GagTweaks;
import pismeno.gagtweaks.Tags;
import pismeno.gagtweaks.actuallyadditions.GAGBlockDisplayStand;
import pismeno.gagtweaks.actuallyadditions.GAGBlockEmpowerer;
import pismeno.gagtweaks.actuallyadditions.GAGTileEntityDisplayStand;
import pismeno.gagtweaks.actuallyadditions.GAGTileEntityEmpowerer;
import pismeno.gagtweaks.common.blocks.BlockCasing;
import pismeno.gagtweaks.common.blocks.BlockCrystal;

import java.util.ArrayList;
import java.util.List;

import static de.ellpeck.actuallyadditions.mod.RegistryHandler.BLOCKS_TO_REGISTER;

public class GAGBlocks {
    public static List<Block> BLOCKS = new ArrayList<>();

    public static Block CARBON_MACHINE_CASING;
    public static Block CARBON_MACHINE_HULL;

    public static Block PECCORITE_CRYSTAL;
    public static Block PECCORITE_CRYSTAL_EMPOWERED;
    public static Block NITANITE_CRYSTAL;
    public static Block NITANITE_CRYSTAL_EMPOWERED;

    public static Block BLOCK_DISPLAY_STAND;
    public static Block BLOCK_EMPOWERER;

    public static void preInit() {
        CARBON_MACHINE_CASING = new BlockCasing("carbon_machine_casing");
        CARBON_MACHINE_HULL = new BlockCasing("carbon_machine_hull");

        PECCORITE_CRYSTAL = new BlockCrystal("peccorite_crystal_block");
        PECCORITE_CRYSTAL_EMPOWERED = new BlockCrystal("peccorite_crystal_block_empowered");

        NITANITE_CRYSTAL = new BlockCrystal("nitanite_crystal_block");
        NITANITE_CRYSTAL_EMPOWERED = new BlockCrystal("nitanite_crystal_block_empowered");

        BLOCK_DISPLAY_STAND = new GAGBlockDisplayStand("gag_block_display_stand");
        BLOCK_EMPOWERER = new GAGBlockEmpowerer("gag_block_empowerer");
        BLOCKS_TO_REGISTER.add(BLOCK_DISPLAY_STAND);
        BLOCKS_TO_REGISTER.add(BLOCK_EMPOWERER);
    }

    public static void init() {
        GameRegistry.registerTileEntity(GAGTileEntityDisplayStand.class, new ResourceLocation(Tags.MODID, "display_stand"));
        GameRegistry.registerTileEntity(GAGTileEntityEmpowerer.class, new ResourceLocation(Tags.MODID, "empowerer"));
    }

    public static void registerModels() {
        for (Block block : BLOCKS) {
            ModelLoader.setCustomModelResourceLocation(
                    Item.getItemFromBlock(block), 0,
                    new ModelResourceLocation(block.getRegistryName(), "inventory")
            );
            GagTweaks.LOGGER.info("Register model for " + block.getRegistryName());
        }
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event){
        for (Block block : BLOCKS) {
            event.getRegistry().register(block);
            GagTweaks.LOGGER.info("Register block for " + block.getRegistryName());
        }
    }

    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Block block : BLOCKS) {
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
            GagTweaks.LOGGER.info("Register item for " + block.getRegistryName());
        }
    }
}

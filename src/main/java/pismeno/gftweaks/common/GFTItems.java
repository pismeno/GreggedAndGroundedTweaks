package pismeno.gftweaks.common;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import pismeno.gftweaks.GfTweaks;
import pismeno.gftweaks.common.items.*;

import java.util.ArrayList;
import java.util.List;

public class GFTItems {
    public static List<Item> ITEMS = new ArrayList<>();

    public static Item PLAN_TIER2;
    public static Item PLAN_TIER3;
    public static Item PLAN_TIER4;
    public static Item PLAN_TIER5;
    public static Item PLAN_TIER6;
    public static Item PLAN_TIER7;
    public static Item PLAN_TIER8;
    public static Item PLAN_TIER9;
    public static Item PLAN_TIER10;
    public static Item PLAN_TIER10_ELECTRIC;
    public static Item PLAN_ROVER_MARS;
    public static Item PLAN_ROVER_VENUS;
    public static Item PLAN_BUGGY_MOON;

    public static Item COKE_OVEN_CLAY;
    public static Item MUDDY_DUST;
    public static Item FILTERED_GROUT;
    public static Item COMPRESSED_GROUT;
    public static Item COMPRESSED_CLAY;
    public static Item PEAT_DUST;
    public static Item BLAZE_CHUNK;

    public static Item HEAVY_DUTY_COMPOSITE;
    public static Item COMPRESSED_HEAVY_DUTY_COMPOSITE;

    public static Item GRAVEL_STRAINER;

    public static Item TINY_PLASTIC_CONTAINER;
    public static Item NETHER_FLAME_SAUCE;

    public static Item PROCESSING_CHIPSET;
    public static Item COMPUTING_CHIPSET;
    public static Item GRAPHIC_CHIPSET;
    public static Item LOGIC_CHIPSET;

    public static void init() {
        PLAN_TIER2 = new ItemPlan("tier2");
        PLAN_TIER3 = new ItemPlan("tier3");
        PLAN_TIER4 = new ItemPlan("tier4");
        PLAN_TIER5 = new ItemPlan("tier5");
        PLAN_TIER6 = new ItemPlan("tier6");
        PLAN_TIER7 = new ItemPlan("tier7");
        PLAN_TIER8 = new ItemPlan("tier8");
        PLAN_TIER9 = new ItemPlan("tier9");
        PLAN_TIER10 = new ItemPlan("tier10");
        PLAN_TIER10_ELECTRIC = new ItemPlan("tier10_electric");
        PLAN_ROVER_MARS = new ItemPlan("rover_mars");
        PLAN_ROVER_VENUS = new ItemPlan("rover_venus");
        PLAN_BUGGY_MOON = new ItemPlan("buggy_moon");

        COKE_OVEN_CLAY = new ItemGeneric("coke_oven_clay");
        MUDDY_DUST = new ItemGeneric("muddy_dust");
        FILTERED_GROUT = new ItemGeneric("filtered_grout");
        COMPRESSED_GROUT = new ItemGeneric("compressed_grout");
        COMPRESSED_CLAY = new ItemGeneric("compressed_clay");
        PEAT_DUST = new ItemGeneric("peat_dust");
        BLAZE_CHUNK = new ItemGeneric("blaze_chunk");

        HEAVY_DUTY_COMPOSITE = new ItemHeavyDuty("heavy_duty_composite");
        COMPRESSED_HEAVY_DUTY_COMPOSITE = new ItemHeavyDuty("compressed_heavy_duty_composite");

        GRAVEL_STRAINER = new ItemGravelStrainer("gravel_strainer");

        TINY_PLASTIC_CONTAINER = new ItemGeneric("tiny_plastic_container");
        NETHER_FLAME_SAUCE = new ItemFoodGeneric("nether_flame_sauce", 3, 16.0F);

        PROCESSING_CHIPSET = new ItemGeneric("processing_chipset");
        COMPUTING_CHIPSET = new ItemGeneric("computing_chipset");
        GRAPHIC_CHIPSET = new ItemGeneric("graphic_chipset");
        LOGIC_CHIPSET = new ItemGeneric("logic_chipset");
    }

    public static void registerModels() {
        for (Item item : ITEMS) {
            ModelLoader.setCustomModelResourceLocation(
                    item, 0,
                    new ModelResourceLocation(item.getRegistryName(), "inventory")
            );
        }
    }

    public static void registerItems(RegistryEvent.Register<Item> event){
        for (Item item : ITEMS) {
            event.getRegistry().register(item);
            GfTweaks.LOGGER.info("Registered item " + item.getRegistryName());
        }
        GfTweaks.LOGGER.info("Registered " + ITEMS.size() + " items");
    }
}

package pismeno.gagtweaks.common;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import pismeno.gagtweaks.common.items.*;

import java.util.ArrayList;
import java.util.List;

public class GAGItems {
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

    public static Item PECCORITE_CRYSTAL;
    public static Item PECCORITE_CRYSTAL_EMPOWERED;
    public static Item NITANITE_CRYSTAL;
    public static Item NITANITE_CRYSTAL_EMPOWERED;

    public static Item HEAVY_DUTY_COMPOSITE;
    public static Item COMPRESSED_HEAVY_DUTY_COMPOSITE;
    public static Item HEAVY_DUTY_COMPOSITE2;
    public static Item COMPRESSED_HEAVY_DUTY_COMPOSITE2;
    public static Item HEAVY_DUTY_COMPOSITE3;
    public static Item HEAVY_DUTY_COMPOSITE4;
    public static Item HEAVY_DUTY_COMPOSITE5;
    public static Item HEAVY_DUTY_COMPOSITE6;
    public static Item HEAVY_DUTY_COMPOSITE7;
    public static Item HEAVY_DUTY_COMPOSITE8;
    public static Item HEAVY_DUTY_COMPOSITE9;

    public static Item GRAVEL_STRAINER;

    public static Item TINY_PLASTIC_CONTAINER;
    public static Item NETHER_FLAME_SAUCE;

    public static Item PROCESSING_CHIPSET;
    public static Item COMPUTING_CHIPSET;
    public static Item GRAPHIC_CHIPSET;
    public static Item LOGIC_CHIPSET;
    public static Item CONTROL_CHIPSET;
    public static Item CENTRAL_CHIPSET;
    public static Item APPLICATING_CHIPSET;
    public static Item LAPOTRONIC_CHIPSET;
    public static Item ADAPTIVE_CHIPSET;
    public static Item ADVANCED_CHIPSET;
    public static Item BETTER_CHIPSET;
    public static Item EXPERT_CHIPSET;
    public static Item ELITE_CHIPSET;
    public static Item CRYSTAL_CHIPSET;
    public static Item GREAT_CHIPSET;
    public static Item BEST_CHIPSET;

    public static Item ENGRAVED_CRYSTAL_CHIPSET;

    public static Item UNBAKED_CORN_BREAD;
    public static Item UNBAKED_RICE_BREAD;
    public static Item UNBAKED_BAGUETTE;

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

        PECCORITE_CRYSTAL = new ItemGeneric("peccorite_crystal");
        PECCORITE_CRYSTAL_EMPOWERED = new ItemGeneric("peccorite_crystal_empowered");
        NITANITE_CRYSTAL = new ItemGeneric("nitanite_crystal");
        NITANITE_CRYSTAL_EMPOWERED = new ItemGeneric("nitanite_crystal_empowered");

        HEAVY_DUTY_COMPOSITE = new ItemHeavyDuty("heavy_duty_composite");
        COMPRESSED_HEAVY_DUTY_COMPOSITE = new ItemHeavyDuty("compressed_heavy_duty_composite");
        HEAVY_DUTY_COMPOSITE2 = new ItemHeavyDuty("heavy_duty_composite2");
        COMPRESSED_HEAVY_DUTY_COMPOSITE2 = new ItemHeavyDuty("compressed_heavy_duty_composite2");
        HEAVY_DUTY_COMPOSITE3 = new ItemHeavyDuty("heavy_duty_composite3");
        HEAVY_DUTY_COMPOSITE4 = new ItemHeavyDuty("heavy_duty_composite4");
        HEAVY_DUTY_COMPOSITE5 = new ItemHeavyDuty("heavy_duty_composite5");
        HEAVY_DUTY_COMPOSITE6 = new ItemHeavyDuty("heavy_duty_composite6");
        HEAVY_DUTY_COMPOSITE7 = new ItemHeavyDuty("heavy_duty_composite7");
        HEAVY_DUTY_COMPOSITE8 = new ItemHeavyDuty("heavy_duty_composite8");
        HEAVY_DUTY_COMPOSITE9 = new ItemHeavyDuty("heavy_duty_composite9");

        GRAVEL_STRAINER = new ItemGravelStrainer("gravel_strainer");

        TINY_PLASTIC_CONTAINER = new ItemGeneric("tiny_plastic_container");
        NETHER_FLAME_SAUCE = new ItemFoodGeneric("nether_flame_sauce", 3, 16.0F);

        PROCESSING_CHIPSET = new ItemGeneric("processing_chipset");
        COMPUTING_CHIPSET = new ItemGeneric("computing_chipset");
        GRAPHIC_CHIPSET = new ItemGeneric("graphic_chipset");
        LOGIC_CHIPSET = new ItemGeneric("logic_chipset");
        CONTROL_CHIPSET = new ItemGeneric("control_chipset");
        CENTRAL_CHIPSET = new ItemGeneric("central_chipset");
        APPLICATING_CHIPSET = new ItemGeneric("applicating_chipset");
        LAPOTRONIC_CHIPSET = new ItemGeneric("lapotronic_chipset");
        ADAPTIVE_CHIPSET = new ItemGeneric("adaptive_chipset");
        ADVANCED_CHIPSET = new ItemGeneric("advanced_chipset");
        BETTER_CHIPSET = new ItemGeneric("better_chipset");
        EXPERT_CHIPSET = new ItemGeneric("expert_chipset");
        ELITE_CHIPSET = new ItemGeneric("elite_chipset");
        CRYSTAL_CHIPSET = new ItemGeneric("crystal_chipset");
        GREAT_CHIPSET = new ItemGeneric("great_chipset");
        BEST_CHIPSET = new ItemGeneric("best_chipset");

        ENGRAVED_CRYSTAL_CHIPSET = new ItemGeneric("engraved_crystal_chipset");

        UNBAKED_RICE_BREAD = new ItemGeneric("unbaked_rice_bread");
        UNBAKED_CORN_BREAD = new ItemGeneric("unbaked_corn_bread");
        UNBAKED_BAGUETTE = new ItemGeneric("unbaked_baguette");
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
        }
    }
}

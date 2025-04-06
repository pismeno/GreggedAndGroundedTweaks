package pismeno.gftweaks.common;

import net.minecraft.item.Item;
import pismeno.gftweaks.galacticraft.SchematicT1;

import java.util.ArrayList;
import java.util.List;

public class GFTItems {
    public static List<Item> ITEMS = new ArrayList<>();

    public static Item TIER1_SCHEMATIC;
    public static Item PLAN;

    public static void init() {
        TIER1_SCHEMATIC = new SchematicT1();
        PLAN = new ItemPlan();

        registerItem(TIER1_SCHEMATIC, "tier1_schematic");
        registerItem(PLAN, "plan");
    }

    public static void registerItem(Item item, String name) {
            item.setRegistryName(name);
        ITEMS.add(item);
    }
}

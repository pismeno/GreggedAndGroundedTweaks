package pismeno.gftweaks.galacticraft;

import com.mjr.extraplanets.items.ExtraPlanets_Items;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pismeno.gftweaks.GfTweaks;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DungeonLoot {
    private static final List<Item> SCHEMATICS = Arrays.asList(
            GCItems.schematic,
            MarsItems.schematic,
            ExtraPlanets_Items.TIER_4_SCHEMATIC,
            ExtraPlanets_Items.TIER_5_SCHEMATIC,
            ExtraPlanets_Items.TIER_6_SCHEMATIC,
            ExtraPlanets_Items.TIER_7_SCHEMATIC,
            ExtraPlanets_Items.TIER_8_SCHEMATIC,
            ExtraPlanets_Items.TIER_9_SCHEMATIC,
            ExtraPlanets_Items.TIER_10_SCHEMATIC,
            ExtraPlanets_Items.TIER_10_ELECTRIC_ROCKET_SCHEMATIC,
            ExtraPlanets_Items.MARS_ROVER_SCHEMATIC,
            ExtraPlanets_Items.VENUS_ROVER_SCHEMATIC,
            VenusItems.volcanicPickaxe
    );

    public static void init() throws NoSuchFieldException, IllegalAccessException {
        Class<?> registry = GalacticraftRegistry.class;

        Field field = registry.getDeclaredField("dungeonLootMap");
        field.setAccessible(true);

        Map<Integer, List<ItemStack>> lootMap = (Map<Integer, List<ItemStack>>) field.get(null);

        for (Item item : SCHEMATICS) {
            removeFromDungeonLoot(item, lootMap);
        }

        //GalacticraftRegistry.addDungeonLoot(1, new ItemStack(GCItems.steelAxe));

            for (Map.Entry<Integer, List<ItemStack>> entry : lootMap.entrySet()) {
                Integer dungeonId = entry.getKey();
                List<ItemStack> lootList = entry.getValue();

                StringBuilder lootInfo = new StringBuilder();
                lootInfo.append("Dungeon ID: ").append(dungeonId).append(" -> Loot: ");

                for (ItemStack item : lootList) {
                    lootInfo.append(item.toString()).append(", ");
                }

                GfTweaks.LOGGER.info(lootInfo.toString());

        }
    }

    private static void removeFromDungeonLoot(Item target, Map<Integer, List<ItemStack>> lootMap) {

        for (Map.Entry<Integer, List<ItemStack>> entry : lootMap.entrySet()) {
            List<ItemStack> lootList = entry.getValue();

            lootList.removeIf(stack -> stack.getItem() == target);
        }
    }
}

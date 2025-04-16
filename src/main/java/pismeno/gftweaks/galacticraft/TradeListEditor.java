package pismeno.gftweaks.galacticraft;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import micdoodle8.mods.galacticraft.core.items.ItemBasic;
import micdoodle8.mods.galacticraft.core.items.ItemCanisterGeneric;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import pismeno.gftweaks.GfTweaks;
import pismeno.gftweaks.common.GFTItems;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TradeListEditor {
    public static void init() {
        try {
            Field tradeListField = EntityAlienVillager.class.getDeclaredField("DEFAULT_TRADE_LIST_MAP");
            tradeListField.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(tradeListField, tradeListField.getModifiers() & ~Modifier.FINAL);

            logTrades(tradeListField);

            EntityAlienVillager.ITradeList[] newTradeList = new EntityAlienVillager.ITradeList[]{
                    new EntityAlienVillager.ListItemForEmeralds(new ItemStack(GCItems.oxMask, 1, 0), new EntityAlienVillager.PriceInfo(8, 12)),
                    new EntityAlienVillager.ListItemForEmeralds(new ItemStack(GCItems.oxTankLight, 1, 235), new EntityAlienVillager.PriceInfo(4, 6)),
                    new EntityAlienVillager.ListItemForEmeralds(new ItemStack(GCItems.oxygenGear, 1, 0), new EntityAlienVillager.PriceInfo(12, 25)),
                    new EntityAlienVillager.ListItemForEmeralds(new ItemStack(GCItems.parachute, 1, 0), new EntityAlienVillager.PriceInfo(4, 10)),
                    new EntityAlienVillager.ItemAndEmeraldToItem(OreDictUnifier.get(OrePrefix.plate, Materials.Tin, 3), new EntityAlienVillager.PriceInfo(1, 1),
                            new ItemStack(GCItems.foodItem, 1, 1)),
                    new EntityAlienVillager.ItemAndEmeraldToItem(new ItemStack(GFTItems.PLAN_TIER2, 1), new EntityAlienVillager.PriceInfo(3, 5), new ItemStack(GFTItems.PLAN_BUGGY_MOON)),
                    new EntityAlienVillager.ItemAndEmeraldToItem(new ItemStack(GFTItems.PLAN_BUGGY_MOON), new EntityAlienVillager.PriceInfo(3, 5), new ItemStack(GFTItems.PLAN_TIER2, 1)),
                    new EntityAlienVillager.EmeraldForItems(new ItemStack(Blocks.SAPLING, 1, 3), new EntityAlienVillager.PriceInfo(11, 39))
            };

            tradeListField.set(null, newTradeList);

            logTrades(tradeListField);

            System.out.println("DEFAULT_TRADE_LIST_MAP successfully cleared.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void logTrades(Field tradeListField) throws IllegalAccessException {
        EntityAlienVillager.ITradeList[] currentTrades = (EntityAlienVillager.ITradeList[]) tradeListField.get(null);
        if (currentTrades != null && currentTrades.length > 0) {
            for (int i = 0; i < currentTrades.length; i++) {
                GfTweaks.LOGGER.info("Trade #" + i + ": " + currentTrades[i].getClass().getSimpleName() + " => " + currentTrades[i]);
            }
        } else {
            GfTweaks.LOGGER.info("DEFAULT_TRADE_LIST_MAP is already empty.");
        }
    }
}

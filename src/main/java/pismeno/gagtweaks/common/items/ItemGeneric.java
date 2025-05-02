package pismeno.gagtweaks.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import pismeno.gagtweaks.Tags;
import pismeno.gagtweaks.common.GAGItems;

public class ItemGeneric extends Item {
    public ItemGeneric(String name) {
        setRegistryName(Tags.MODID, name);
        setTranslationKey(Tags.MODID + "." + name);
        setCreativeTab(CreativeTabs.MISC);

        GAGItems.ITEMS.add(this);
    }
}
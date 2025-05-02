package pismeno.gagtweaks.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import pismeno.gagtweaks.Tags;
import pismeno.gagtweaks.common.GAGItems;

public class ItemGravelStrainer extends Item {
    public ItemGravelStrainer(String name) {
        setMaxStackSize(1);
        setMaxDamage(30);
        setRegistryName(Tags.MODID, name);
        setTranslationKey(Tags.MODID + "." + name);
        setCreativeTab(CreativeTabs.MISC);

        GAGItems.ITEMS.add(this);
    }
}
package pismeno.gftweaks.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import pismeno.gftweaks.Tags;
import pismeno.gftweaks.common.GFTItems;

public class ItemGeneric extends Item {
    public ItemGeneric(String name) {
        setRegistryName(Tags.MODID, name);
        setTranslationKey(Tags.MODID + "." + name);
        setCreativeTab(CreativeTabs.MISC);

        GFTItems.ITEMS.add(this);
    }
}
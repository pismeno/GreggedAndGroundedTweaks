package pismeno.gagtweaks.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import pismeno.gagtweaks.Tags;
import pismeno.gagtweaks.common.GAGItems;

public class ItemFoodGeneric extends ItemFood {
    public ItemFoodGeneric(String name, int amount, float saturation) {
        super(amount, saturation, false);
        setRegistryName(Tags.MODID, name);
        setTranslationKey(Tags.MODID + "." + name);
        setCreativeTab(CreativeTabs.FOOD);

        GAGItems.ITEMS.add(this);
    }
}

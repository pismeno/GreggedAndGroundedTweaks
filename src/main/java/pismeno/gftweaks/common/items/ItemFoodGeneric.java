package pismeno.gftweaks.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import pismeno.gftweaks.Tags;
import pismeno.gftweaks.common.GFTItems;

public class ItemFoodGeneric extends ItemFood {
    public ItemFoodGeneric(String name, int amount, float saturation) {
        super(amount, saturation, false);
        setRegistryName(Tags.MODID, name);
        setTranslationKey(Tags.MODID + "." + name);
        setCreativeTab(CreativeTabs.FOOD);

        GFTItems.ITEMS.add(this);
    }
}

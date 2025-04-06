package pismeno.gftweaks.common;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import pismeno.gftweaks.Tags;

public class ItemPlan extends Item {

    private static final String[] ITEM_NAMES = {
            "Item Variant 1",
            "Item Variant 2",
            "Item Variant 3",
            "Item Variant 4",
            "Item Variant 5",
            "Item Variant 6",
            "Item Variant 7",
            "Item Variant 8",
            "Item Variant 9",
            "Item Variant 10"
    };

    public ItemPlan() {
        setHasSubtypes(true);
        setMaxStackSize(1);
        setRegistryName(new ResourceLocation(Tags.MODID, "multi_meta_item"));
        setTranslationKey("multi_meta_item");
        setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public String getUnlocalizedNameInefficiently(ItemStack stack) {
        int meta = stack.getMetadata();
        return super.getTranslationKey() + "_" + meta;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        int meta = stack.getMetadata();
        return I18n.translateToLocal("item.multi_meta_item." + meta);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            for (int i = 0; i < 10; i++) {
                items.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}

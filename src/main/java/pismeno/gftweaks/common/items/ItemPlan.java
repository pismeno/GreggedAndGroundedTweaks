package pismeno.gftweaks.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import pismeno.gftweaks.Tags;
import pismeno.gftweaks.common.GFTItems;

import javax.annotation.Nullable;
import java.util.List;

public class ItemPlan extends Item {
    public ItemPlan(String name) {
        setMaxStackSize(1);
        setRegistryName(Tags.MODID, "plan_" + name);
        setTranslationKey(Tags.MODID + ".plan_" + name);
        setCreativeTab(CreativeTabs.MISC);

        GFTItems.ITEMS.add(this);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.translateToLocal(stack.getItem().getTranslationKey() + ".tooltip"));

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            tooltip.add(I18n.translateToLocal("item.gftweaks.plan.extended_tooltip"));
        } else {
            tooltip.add(I18n.translateToLocal("gftweaks.press_shift.tooltip"));
        }
    }
}

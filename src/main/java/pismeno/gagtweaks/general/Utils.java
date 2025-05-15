package pismeno.gagtweaks.general;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Utils {
    public static ItemStack getItemStack(String registryName, int meta, int count) {
        try {
            ResourceLocation resourceLocation = new ResourceLocation(registryName);
            Item item = ForgeRegistries.ITEMS.getValue(resourceLocation);

            if (item == null) {
                System.err.println("Item not found: " + registryName);
                return ItemStack.EMPTY;
            }

            return new ItemStack(item, count, meta);
        } catch (Exception e) {
            System.err.println("Error creating ItemStack for: " + registryName);
            e.printStackTrace();
            return ItemStack.EMPTY;
        }
    }
}

package pismeno.gftweaks.general;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import de.ellpeck.actuallyadditions.mod.items.InitItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
    public static void init() {
        OreDictionary.registerOre("gemRestonia", new ItemStack(InitItems.itemCrystal, 1, 0));
        OreDictionary.registerOre("gemPalis", new ItemStack(InitItems.itemCrystal, 1, 1));
        OreDictionary.registerOre("gemDiamatine", new ItemStack(InitItems.itemCrystal, 1, 2));
        OreDictionary.registerOre("gemVoid", new ItemStack(InitItems.itemCrystal, 1, 3));
        OreDictionary.registerOre("gemEmeradic", new ItemStack(InitItems.itemCrystal, 1, 4));
        OreDictionary.registerOre("gemEnori", new ItemStack(InitItems.itemCrystal, 1, 5));

        OreDictionary.registerOre("blockRestonia", new ItemStack(InitBlocks.blockCrystal, 1, 0));
        OreDictionary.registerOre("blockPalis", new ItemStack(InitBlocks.blockCrystal, 1, 1));
        OreDictionary.registerOre("blockDiamatine", new ItemStack(InitBlocks.blockCrystal, 1, 2));
        OreDictionary.registerOre("blockVoid", new ItemStack(InitBlocks.blockCrystal, 1, 3));
        OreDictionary.registerOre("blockEmeradic", new ItemStack(InitBlocks.blockCrystal, 1, 4));
        OreDictionary.registerOre("blockEnori", new ItemStack(InitBlocks.blockCrystal, 1, 5));
    }
}

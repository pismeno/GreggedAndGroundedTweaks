package pismeno.gftweaks.galacticraft;

import java.util.List;
import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicItem;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.items.ISortableItem;
import micdoodle8.mods.galacticraft.core.items.ItemSchematic;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import pismeno.gftweaks.Tags;
import pismeno.gftweaks.common.GFTItems;

public class SchematicT1 extends ItemSchematic implements ISchematicItem, ISortableItem
{

    private static int indexOffset = 0;

    public SchematicT1()
    {
        super("schematic_tier1");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public CreativeTabs getCreativeTab()
    {
        return GalacticraftCore.galacticraftItemsTab;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        list.add(new ItemStack(this, 1, 0));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {

    }

    @Override
    public EnumSortCategoryItem getCategory(int meta)
    {
        return EnumSortCategoryItem.SCHEMATIC;
    }

    /**
     * Higher tiers should use this form and make sure they have set up the
     * indexOffset correctly in registerSchematicItems()
     */
    @Override
    protected int getIndex(int damage)
    {
        return damage + indexOffset;
    }

    /**
     * Make sure the number of these will match the index values
     */
    public static void registerSchematicItems()
    {
        indexOffset = SchematicRegistry.registerSchematicItem(new ItemStack(GFTItems.TIER1_SCHEMATIC, 1, 0));
    }

    /**
     * Make sure the order of these will match the index values
     */
    @SideOnly(value = Side.CLIENT)
    public static void registerTextures()
    {
        SchematicRegistry.registerTexture(new ResourceLocation(Tags.MODID, "textures/items/schematic_rocket_t1.png"));
    }
}
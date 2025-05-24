package pismeno.gagtweaks.general;

import de.ellpeck.actuallyadditions.mod.jei.empowerer.EmpowererRecipeCategory;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import net.minecraft.item.ItemStack;
import pismeno.gagtweaks.common.GAGBlocks;

@JEIPlugin
public class JEIPluginGAG implements IModPlugin {
    @Override
    public void register(IModRegistry registry) {
        IJeiHelpers helpers = registry.getJeiHelpers();

        registry.addRecipeCatalyst(new ItemStack(GAGBlocks.BLOCK_EMPOWERER), EmpowererRecipeCategory.NAME);
    }
}

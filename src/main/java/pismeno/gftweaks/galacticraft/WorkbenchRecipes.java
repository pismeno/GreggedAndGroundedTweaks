package pismeno.gftweaks.galacticraft;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.recipe.NasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class WorkbenchRecipes {

    public static HashMap<Integer, ItemStack> cargoInputs = new HashMap<>();
    public static HashMap<Integer, ItemStack> minerInputs = new HashMap<>();

    static {
        cargoInputs.put(1, new ItemStack(GCItems.partNoseCone));
        cargoInputs.put(2, new ItemStack(MarsItems.marsItemBasic, 1 , 3));
        cargoInputs.put(3, new ItemStack(MarsItems.marsItemBasic, 1 , 3));
        cargoInputs.put(4, new ItemStack(MarsItems.marsItemBasic, 1 , 3));
        cargoInputs.put(5, new ItemStack(MarsItems.marsItemBasic, 1 , 3));
        cargoInputs.put(6, new ItemStack(MarsItems.marsItemBasic, 1 , 3));
        cargoInputs.put(7, new ItemStack(MarsItems.marsItemBasic, 1 , 3));
        cargoInputs.put(8, new ItemStack(MarsItems.marsItemBasic, 1 , 3));
        cargoInputs.put(9, new ItemStack(GCItems.partFins));
        cargoInputs.put(10, new ItemStack(GCItems.partFins));
        cargoInputs.put(11, new ItemStack(GCItems.rocketEngine));
        cargoInputs.put(12, new ItemStack(GCItems.partFins));
        cargoInputs.put(13, new ItemStack(GCItems.partFins));

        minerInputs.put(1, new ItemStack(GCItems.heavyPlatingTier1));
        minerInputs.put(2, new ItemStack(GCItems.heavyPlatingTier1));
        minerInputs.put(3, new ItemStack(GCItems.heavyPlatingTier1));
        minerInputs.put(4, new ItemStack(GCItems.heavyPlatingTier1));
        minerInputs.put(5, new ItemStack(GCItems.heavyPlatingTier1));
        minerInputs.put(6, new ItemStack(GCItems.heavyPlatingTier1));
        minerInputs.put(9, new ItemStack(GCItems.rocketEngine));
        minerInputs.put(10, new ItemStack(GCItems.heavyPlatingTier1));
        minerInputs.put(11, new ItemStack(GCItems.heavyPlatingTier1));
        minerInputs.put(12, new ItemStack(GCItems.heavyPlatingTier1));
        minerInputs.put(13, new ItemStack(AsteroidsItems.basicItem, 1, 8));
        minerInputs.put(14, new ItemStack(GCItems.flagPole));
    }

    public static void init() {
        GalacticraftRegistry.removeAllCargoRocketRecipes();
        GalacticraftRegistry.removeAllAstroMinerRecipes();

        ItemStack[] inputs = new ItemStack[0];

        // Meta 0: No chests
        HashMap<Integer, ItemStack> variant = new HashMap<>(cargoInputs);

        for (int i = 14; i <= 16; i++) {
            variant = new HashMap<>(cargoInputs);
            for (int j = 14; j <= 16; j++) {
                variant.put(j, i == j ? new ItemStack(Blocks.CHEST) : ItemStack.EMPTY);
            }
            GalacticraftRegistry.addCargoRocketRecipe(new NasaWorkbenchRecipe(new ItemStack(MarsItems.rocketMars, 1, 11), variant));
        }

        // Meta 2: Chests ONLY in slots 14 and 15
        variant = new HashMap<>(cargoInputs);
        variant.put(14, new ItemStack(Blocks.CHEST));
        variant.put(15, new ItemStack(Blocks.CHEST));
        variant.put(16, ItemStack.EMPTY);
        GalacticraftRegistry.addCargoRocketRecipe(new NasaWorkbenchRecipe(new ItemStack(MarsItems.rocketMars, 1, 12), variant));

        // Meta 3: Chests in all three slots
        variant = new HashMap<>(cargoInputs);
        variant.put(14, new ItemStack(Blocks.CHEST));
        variant.put(15, new ItemStack(Blocks.CHEST));
        variant.put(16, new ItemStack(Blocks.CHEST));
        GalacticraftRegistry.addCargoRocketRecipe(new NasaWorkbenchRecipe(new ItemStack(MarsItems.rocketMars, 1, 13), variant));

        for (int i = 14; i <= 16; i++) {
            variant = new HashMap<>(cargoInputs);
            for (int j = 14; j <= 16; j++) {
                variant.put(j, i == j ? new ItemStack(Blocks.TRAPPED_CHEST) : ItemStack.EMPTY);
            }
            GalacticraftRegistry.addCargoRocketRecipe(new NasaWorkbenchRecipe(new ItemStack(MarsItems.rocketMars, 1, 11), variant));
        }

        // Meta 2: Chests ONLY in slots 14 and 15
        variant = new HashMap<>(cargoInputs);
        variant.put(14, new ItemStack(Blocks.TRAPPED_CHEST));
        variant.put(15, new ItemStack(Blocks.TRAPPED_CHEST));
        variant.put(16, ItemStack.EMPTY);
        GalacticraftRegistry.addCargoRocketRecipe(new NasaWorkbenchRecipe(new ItemStack(MarsItems.rocketMars, 1, 12), variant));

        // Meta 3: Chests in all three slots
        variant = new HashMap<>(cargoInputs);
        variant.put(14, new ItemStack(Blocks.TRAPPED_CHEST));
        variant.put(15, new ItemStack(Blocks.TRAPPED_CHEST));
        variant.put(16, new ItemStack(Blocks.TRAPPED_CHEST));
        GalacticraftRegistry.addCargoRocketRecipe(new NasaWorkbenchRecipe(new ItemStack(MarsItems.rocketMars, 1, 13), variant));

        variant = new HashMap<>(minerInputs);
        variant.put(7, new ItemStack(Blocks.CHEST));
        variant.put(8, new ItemStack(Blocks.CHEST));
        GalacticraftRegistry.addAstroMinerRecipe((new NasaWorkbenchRecipe(new ItemStack(AsteroidsItems.astroMiner), variant)));

        variant = new HashMap<>(minerInputs);
        variant.put(7, new ItemStack(Blocks.TRAPPED_CHEST));
        variant.put(8, new ItemStack(Blocks.TRAPPED_CHEST));
        GalacticraftRegistry.addAstroMinerRecipe((new NasaWorkbenchRecipe(new ItemStack(AsteroidsItems.astroMiner), variant)));
    }
}

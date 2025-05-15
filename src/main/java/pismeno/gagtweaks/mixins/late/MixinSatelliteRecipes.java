package pismeno.gagtweaks.mixins.late;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.recipes.ExtraPlanets_Recipes;
import com.mjr.extraplanets.util.GCRecipeUtilities;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import micdoodle8.mods.galacticraft.planets.venus.VenusModule;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import slimeknights.tconstruct.shared.TinkerCommons;

import java.util.HashMap;

import static pismeno.gagtweaks.general.Utils.getItemStack;

@Mixin(
        value = {ExtraPlanets_Recipes.class},
        remap = false
)
public class MixinSatelliteRecipes {

    /**
     * @author PismenoK
     * @reason Changing Space Stations recipes.
     */
    @Overwrite
    private static void registerSatellitesRecipes() {
        HashMap<Object, Integer> inputMap;
        if (Config.MERCURY_SPACE_STATION && Config.MERCURY) {
            inputMap = new HashMap<Object, Integer>();
            inputMap.put(getItemStack("xtones:base", 0, 1), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Steel), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Polyethylene), 32);
            inputMap.put(TinkerCommons.blockClearGlass, 16);
            GCRecipeUtilities.addSpaceStationRecipe(Config.MERCURY_SPACE_STATION_ID, Config.MERCURY_ID, inputMap);
        }
        if (Config.VENUS_SPACE_STATION) {
            inputMap = new HashMap<Object, Integer>();
            inputMap.put(getItemStack("xtones:base", 0, 1), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Steel), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Polyethylene), 32);
            inputMap.put(TinkerCommons.blockClearGlass, 16);
            GCRecipeUtilities.addSpaceStationRecipe(Config.VENUS_SPACE_STATION_ID, VenusModule.planetVenus.getDimensionID(), inputMap);
        }
        if (Config.CERES_SPACE_STATION && Config.CERES) {
            inputMap = new HashMap<Object, Integer>();
            inputMap.put(getItemStack("xtones:base", 0, 1), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Steel), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Polyethylene), 32);
            inputMap.put(TinkerCommons.blockClearGlass, 16);
            GCRecipeUtilities.addSpaceStationRecipe(Config.CERES_SPACE_STATION_ID, Config.CERES_ID, inputMap);
        }
        if (Config.MARS_SPACE_STATION && MarsModule.planetMars != null) {
            inputMap = new HashMap<Object, Integer>();
            inputMap.put(getItemStack("xtones:base", 0, 1), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Steel), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Polyethylene), 32);
            inputMap.put(TinkerCommons.blockClearGlass, 16);
            GCRecipeUtilities.addSpaceStationRecipe(Config.MARS_SPACE_STATION_ID, MarsModule.planetMars.getDimensionID(), inputMap);
        }
        if (Config.JUPITER_SPACE_STATION && Config.JUPITER) {
            inputMap = new HashMap<Object, Integer>();
            inputMap.put(getItemStack("xtones:base", 0, 1), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Steel), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Polyethylene), 32);
            inputMap.put(TinkerCommons.blockClearGlass, 16);
            GCRecipeUtilities.addSpaceStationRecipe(Config.JUPITER_SPACE_STATION_ID, Config.JUPITER_ID, inputMap);
        }
        if (Config.SATURN_SPACE_STATION && Config.SATURN) {
            inputMap = new HashMap<Object, Integer>();
            inputMap.put(getItemStack("xtones:base", 0, 1), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Steel), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Polyethylene), 32);
            inputMap.put(TinkerCommons.blockClearGlass, 16);
            GCRecipeUtilities.addSpaceStationRecipe(Config.SATURN_SPACE_STATION_ID, Config.SATURN_ID, inputMap);
        }
        if (Config.URANUS_SPACE_STATION && Config.URANUS) {
            inputMap = new HashMap<Object, Integer>();
            inputMap.put(getItemStack("xtones:base", 0, 1), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Steel), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Polyethylene), 32);
            inputMap.put(TinkerCommons.blockClearGlass, 16);
            GCRecipeUtilities.addSpaceStationRecipe(Config.URANUS_SPACE_STATION_ID, Config.URANUS_ID, inputMap);
        }
        if (Config.NEPTUNE_SPACE_STATION && Config.NEPTUNE) {
            inputMap = new HashMap<Object, Integer>();
            inputMap.put(getItemStack("xtones:base", 0, 1), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Steel), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Polyethylene), 32);
            inputMap.put(TinkerCommons.blockClearGlass, 16);
            GCRecipeUtilities.addSpaceStationRecipe(Config.NEPTUNE_SPACE_STATION_ID, Config.NEPTUNE_ID, inputMap);
        }
        if (Config.PLUTO_SPACE_STATION && Config.PLUTO) {
            inputMap = new HashMap<Object, Integer>();
            inputMap.put(getItemStack("xtones:base", 0, 1), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Steel), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Polyethylene), 32);
            inputMap.put(TinkerCommons.blockClearGlass, 16);
            GCRecipeUtilities.addSpaceStationRecipe(Config.PLUTO_SPACE_STATION_ID, Config.PLUTO_ID, inputMap);
        }
        if (Config.ERIS_SPACE_STATION && Config.ERIS) {
            inputMap = new HashMap<Object, Integer>();
            inputMap.put(getItemStack("xtones:base", 0, 1), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Steel), 64);
            inputMap.put(OreDictUnifier.get(OrePrefix.plate, Materials.Polyethylene), 32);
            inputMap.put(TinkerCommons.blockClearGlass, 16);
            GCRecipeUtilities.addSpaceStationRecipe(Config.ERIS_SPACE_STATION_ID, Config.ERIS_ID, inputMap);
        }
        if (Config.KEPLER22B_SPACE_STATION && Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
            inputMap = new HashMap<Object, Integer>();
            inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 0), 24);
            inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 1), 24);
            inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 2), 24);
            inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 3), 24);
            inputMap.put(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 4), 24);
            GCRecipeUtilities.addSpaceStationRecipe(Config.KEPLER22B_SPACE_STATION_ID, Config.KEPLER22B_ID, inputMap);
        }
    };
}

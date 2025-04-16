package pismeno.gftweaks.gregtech;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicMercury;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.StoneType;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockBasicMoon;
import micdoodle8.mods.galacticraft.planets.mars.blocks.BlockBasicMars;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import micdoodle8.mods.galacticraft.planets.venus.blocks.BlockBasicVenus;
import net.minecraft.block.SoundType;

public class GFTStoneTypes {

    private GFTStoneTypes() {}

    public static void init() {
        StoneType MOONROCK = new StoneType(12, "moonrock", SoundType.STONE, GFTOrePrefix.oreMoonRock, Materials.Copper,
                () -> GCBlocks.blockMoon.getStateFromMeta(4), state -> state.getBlock() instanceof BlockBasicMoon && state == GCBlocks.blockMoon.getStateFromMeta(4), true);

        StoneType MARSROCK = new StoneType(13, "marsrock", SoundType.STONE, GFTOrePrefix.oreMarsRock, Materials.Copper,
                () -> MarsBlocks.marsBlock.getStateFromMeta(9), state -> state.getBlock() instanceof BlockBasicMars && state == MarsBlocks.marsBlock.getStateFromMeta(9), true);

        StoneType VENUSROCK = new StoneType(14, "venusrock", SoundType.STONE, GFTOrePrefix.oreMarsRock, Materials.Copper,
                () -> VenusBlocks.venusBlock.getStateFromMeta(1), state -> state.getBlock() instanceof BlockBasicVenus && state == VenusBlocks.venusBlock.getStateFromMeta(1), true);

        StoneType MERCURYROCK = new StoneType(15, "mercuryrock", SoundType.STONE, GFTOrePrefix.oreMercuryRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.MERCURY_BLOCKS.getStateFromMeta(2), state -> state.getBlock() instanceof BlockBasicMercury && state == ExtraPlanets_Blocks.MERCURY_BLOCKS.getStateFromMeta(2), true);
    }
}

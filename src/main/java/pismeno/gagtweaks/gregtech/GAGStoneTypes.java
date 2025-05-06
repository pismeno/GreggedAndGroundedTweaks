package pismeno.gagtweaks.gregtech;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.*;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.StoneType;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockBasicMoon;
import micdoodle8.mods.galacticraft.planets.mars.blocks.BlockBasicMars;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import micdoodle8.mods.galacticraft.planets.venus.blocks.BlockBasicVenus;
import net.minecraft.block.SoundType;

public class GAGStoneTypes {

    private GAGStoneTypes() {}

    public static void init() {
        new StoneType(12, "moonrock", SoundType.STONE, GAGOrePrefix.oreMoonRock, Materials.Copper,
                () -> GCBlocks.blockMoon.getStateFromMeta(4),
                state -> state.getBlock() instanceof BlockBasicMoon
                        && state.equals(GCBlocks.blockMoon.getStateFromMeta(4)), true);

        new StoneType(13, "marsrock", SoundType.STONE, GAGOrePrefix.oreMarsRock, Materials.Copper,
                () -> MarsBlocks.marsBlock.getStateFromMeta(9),
                state -> state.getBlock() instanceof BlockBasicMars
                        && state.equals(MarsBlocks.marsBlock.getStateFromMeta(9)), true);

        new StoneType(14, "venusrock", SoundType.STONE, GAGOrePrefix.oreVenusRock, Materials.Copper,
                () -> VenusBlocks.venusBlock.getStateFromMeta(1),
                state -> state.getBlock() instanceof BlockBasicVenus
                        && state.equals(VenusBlocks.venusBlock.getStateFromMeta(1)), true);

        new StoneType(15, "mercuryrock", SoundType.STONE, GAGOrePrefix.oreMercuryRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.MERCURY_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicMercury, true);

        new StoneType(16, "ceresrock", SoundType.STONE, GAGOrePrefix.oreCeresRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.CERES_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicCeres, true);

        new StoneType(17, "saturnrock", SoundType.STONE, GAGOrePrefix.oreSaturnRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.SATURN_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicSaturn, true);

        new StoneType(18, "jupiterrock", SoundType.STONE, GAGOrePrefix.oreJupiterRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.JUPITER_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicJupiter, true);

        new StoneType(19, "uranusrock", SoundType.STONE, GAGOrePrefix.oreUranusRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.URANUS_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicUranus, true);

        new StoneType(20, "neptunerock", SoundType.STONE, GAGOrePrefix.oreNeptuneRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.NEPTUNE_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicNeptune, true);

        new StoneType(21, "plutorock", SoundType.STONE, GAGOrePrefix.orePlutoRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.PLUTO_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicPluto, true);

        new StoneType(22, "erisrock", SoundType.STONE, GAGOrePrefix.oreErisRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.ERIS_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicEris, true);

        new StoneType(23, "kepler22brock", SoundType.STONE, GAGOrePrefix.oreKepler22bRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1),
                state -> state.getBlock() instanceof BlockBasicKepler22b, true);

        new StoneType(24, "europarock", SoundType.STONE, GAGOrePrefix.oreEuropaRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.EUROPA_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicEuropa, true);

        new StoneType(25, "callistorock", SoundType.STONE, GAGOrePrefix.oreCallistoRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.CALLISTO_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicCallisto, true);

        new StoneType(26, "iorock", SoundType.STONE, GAGOrePrefix.oreIoRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.IO_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicIo, true);

        new StoneType(27, "ganymederock", SoundType.STONE, GAGOrePrefix.oreGanymedeRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.GANYMEDE_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicGanymede, true);

        new StoneType(28, "rhearock", SoundType.STONE, GAGOrePrefix.oreRheaRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.RHEA_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicRhea, true);

        new StoneType(29, "titanrock", SoundType.STONE, GAGOrePrefix.oreTitanRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.TITAN_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicTitan, true);

        new StoneType(30, "iapetusrock", SoundType.STONE, GAGOrePrefix.oreIapetusRock, Materials.Copper,
                () -> ExtraPlanets_Blocks.IAPETUS_BLOCKS.getStateFromMeta(2),
                state -> state.getBlock() instanceof BlockBasicIapetus, true);
    }
}
package pismeno.gftweaks.gregtech;

import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class GFTOrePrefix {
    public static final OrePrefix chipEngraved = new OrePrefix("chipEngraved", M * 4, null, GFTMaterialIconTypes.chipEngraved,
            ENABLE_UNIFICATION, material -> material.hasFlag(GFTMaterialFlags.GENERATE_CHIPS));

    public static final OrePrefix chipRaw = new OrePrefix("chipRaw", M * 4, null, GFTMaterialIconTypes.chipRaw,
            ENABLE_UNIFICATION, material -> material.hasFlag(GFTMaterialFlags.GENERATE_CHIPS));

    public static final OrePrefix cuttingBlade = new OrePrefix("cuttingBlade", M * 4, null, GFTMaterialIconTypes.cuttingBlade,
            ENABLE_UNIFICATION, material -> material.hasFlag(GFTMaterialFlags.GENERATE_CUTTING_BLADE) && material.hasFlag(MaterialFlags.GENERATE_PLATE));
}

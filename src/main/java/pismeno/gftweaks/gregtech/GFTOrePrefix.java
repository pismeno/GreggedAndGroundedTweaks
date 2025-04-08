package pismeno.gftweaks.gregtech;

import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class GFTOrePrefix {
    public static final OrePrefix chipEngraved = new OrePrefix("chipEngraved", M * 3, null, GFTMaterialIconTypes.chipEngraved,
            ENABLE_UNIFICATION, material -> material.hasFlag(GFTMaterialFlags.GENERATE_CHIPS) && material.hasProperty(PropertyKey.GEM));
}

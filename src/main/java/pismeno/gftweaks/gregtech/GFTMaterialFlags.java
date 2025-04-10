package pismeno.gftweaks.gregtech;

import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;

public class GFTMaterialFlags {
    public static final MaterialFlag GENERATE_CHIPS = new MaterialFlag.Builder("generate_chips")
            .requireFlags(MaterialFlags.GENERATE_PLATE)
            .build();

    public static final MaterialFlag GENERATE_CUTTING_BLADE = new MaterialFlag.Builder("generate_cutting_blade")
            .requireFlags(MaterialFlags.GENERATE_PLATE)
            .build();
}

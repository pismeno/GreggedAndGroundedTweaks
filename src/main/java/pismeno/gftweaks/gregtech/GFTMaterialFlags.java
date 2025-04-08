package pismeno.gftweaks.gregtech;

import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.properties.PropertyKey;

public class GFTMaterialFlags {
    public static final MaterialFlag GENERATE_CHIPS = new MaterialFlag.Builder("generate_chips")
            .requireProps(PropertyKey.GEM)
            .build();
}

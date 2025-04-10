package pismeno.gftweaks.gregtech;

import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import pismeno.gftweaks.GfTweaks;

import static gregtech.api.unification.material.Materials.*;
import static pismeno.gregstinkering.unification.GTCGregtechMaterials.*;

public class MaterialModifications {
    public static void init() {
        Ardite.setProperty(PropertyKey.BLAST, new BlastProperty(1780));
        Flint.setMaterialRGB(0x565656);

        Manyullyn.addFlags(MaterialFlags.GENERATE_FOIL);
        Amethyst.addFlags(GFTMaterialFlags.GENERATE_CHIPS);
        Lapotron.addFlags(GFTMaterialFlags.GENERATE_CHIPS);
        Emerald.addFlags(GFTMaterialFlags.GENERATE_CHIPS);

        GfTweaks.LOGGER.info("Material modifications initialized");
    }

    private MaterialModifications() {}
}

package pismeno.gftweaks.gregtech;

import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import pismeno.gftweaks.GfTweaks;

import static gregtech.api.unification.material.Materials.*;
import static pismeno.gftweaks.gregtech.GFTMaterials.*;
import static pismeno.gregstinkering.unification.GTCGregtechMaterials.*;

public class MaterialModifications {
    public static void init() {
        Ardite.setProperty(PropertyKey.BLAST, new BlastProperty(1780));
        Flint.setMaterialRGB(0x565656);
        Electrotine.setProperty(PropertyKey.INGOT, new IngotProperty());
        Electrotine.setMaterialRGB(0x0E73AA);
        Electrotine.setMaterialIconSet(MaterialIconSet.METALLIC);


        Silicon.addFlags(MaterialFlags.GENERATE_DOUBLE_PLATE);
        CertusQuartz.addFlags(MaterialFlags.GENERATE_DOUBLE_PLATE);
        BlueAlloy.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        Graphene.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        BlackSteel.addFlags(MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_RING);

        Diamond.addFlags(GFTMaterialFlags.GENERATE_CHIPS);
        GarnetYellow.addFlags(GFTMaterialFlags.GENERATE_CHIPS);
        Amethyst.addFlags(GFTMaterialFlags.GENERATE_CHIPS);
        Lapotron.addFlags(GFTMaterialFlags.GENERATE_CHIPS);
        Emerald.addFlags(GFTMaterialFlags.GENERATE_CHIPS);

        Manyullyn.addFlags(MaterialFlags.GENERATE_FOIL);
        Copper.addFlags(MaterialFlags.GENERATE_FOIL);
        Tin.addFlags(MaterialFlags.GENERATE_FOIL);
        Steel.addFlags(MaterialFlags.GENERATE_FOIL);
        Bronze.addFlags(MaterialFlags.GENERATE_FOIL);
        Iron.addFlags(MaterialFlags.GENERATE_FOIL);
        PolyvinylButyral.addFlags(MaterialFlags.GENERATE_FOIL);

        CobaltBrass.addFlags(GFTMaterialFlags.GENERATE_CUTTING_BLADE);
        VanadiumSteel.addFlags(GFTMaterialFlags.GENERATE_CUTTING_BLADE);
        BlueSteel.addFlags(GFTMaterialFlags.GENERATE_CUTTING_BLADE);
        Ultimet.addFlags(GFTMaterialFlags.GENERATE_CUTTING_BLADE);
        TungstenCarbide.addFlags(GFTMaterialFlags.GENERATE_CUTTING_BLADE);
        HSSE.addFlags(GFTMaterialFlags.GENERATE_CUTTING_BLADE);
        NaquadahAlloy.addFlags(GFTMaterialFlags.GENERATE_CUTTING_BLADE);
        Duranium.addFlags(GFTMaterialFlags.GENERATE_CUTTING_BLADE);

        Copper.addFlags(MaterialFlags.GENERATE_DENSE);
        Aluminium.addFlags(MaterialFlags.GENERATE_DENSE);
        Titanium.addFlags(MaterialFlags.GENERATE_DENSE);
        Iron.addFlags(MaterialFlags.GENERATE_DENSE);
        Tin.addFlags(MaterialFlags.GENERATE_DENSE);
        Steel.addFlags(MaterialFlags.GENERATE_DENSE);
        Bronze.addFlags(MaterialFlags.GENERATE_DENSE);
        Nickel.addFlags(MaterialFlags.GENERATE_DENSE);
        Palladium.addFlags(MaterialFlags.GENERATE_DENSE);
        Platinum.addFlags(MaterialFlags.GENERATE_DENSE);
        Tungsten.addFlags(MaterialFlags.GENERATE_DENSE);
        Zinc.addFlags(MaterialFlags.GENERATE_DENSE);

        GfTweaks.LOGGER.info("Material modifications initialized");
    }

    private MaterialModifications() {}
}

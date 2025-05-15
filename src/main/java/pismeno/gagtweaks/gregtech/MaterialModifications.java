package pismeno.gagtweaks.gregtech;

import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import pismeno.gagtweaks.GagTweaks;

import static gregtech.api.unification.material.Materials.*;
import static pismeno.gregstinkering.unification.GTCGregtechMaterials.*;

public class MaterialModifications {
    public static void init() {
        Ardite.setProperty(PropertyKey.BLAST, new BlastProperty(1780));
        Flint.setMaterialRGB(0x565656);
        Electrotine.setProperty(PropertyKey.INGOT, new IngotProperty());
        Electrotine.setMaterialRGB(0x0E73AA);
        Electrotine.setMaterialIconSet(MaterialIconSet.METALLIC);


        Silicon.addFlags(MaterialFlags.GENERATE_DOUBLE_PLATE);
        HSSE.addFlags(MaterialFlags.GENERATE_DOUBLE_PLATE);
        Tritanium.addFlags(MaterialFlags.GENERATE_DOUBLE_PLATE);
        BlueAlloy.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        Graphene.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        BlackSteel.addFlags(MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_RING);

        Diamond.addFlags(GAGMaterialFlags.GENERATE_CHIPS);
        GarnetYellow.addFlags(GAGMaterialFlags.GENERATE_CHIPS);
        Amethyst.addFlags(GAGMaterialFlags.GENERATE_CHIPS);
        Lapotron.addFlags(GAGMaterialFlags.GENERATE_CHIPS);
        Emerald.addFlags(GAGMaterialFlags.GENERATE_CHIPS);
        Olivine.addFlags(GAGMaterialFlags.GENERATE_CHIPS);

        Manyullyn.addFlags(MaterialFlags.GENERATE_FOIL);
        Copper.addFlags(MaterialFlags.GENERATE_FOIL);
        Tin.addFlags(MaterialFlags.GENERATE_FOIL);
        Steel.addFlags(MaterialFlags.GENERATE_FOIL);
        Bronze.addFlags(MaterialFlags.GENERATE_FOIL);
        Iron.addFlags(MaterialFlags.GENERATE_FOIL);
        RhodiumPlatedPalladium.addFlags(MaterialFlags.GENERATE_FOIL);

        CobaltBrass.addFlags(GAGMaterialFlags.GENERATE_CUTTING_BLADE);
        VanadiumSteel.addFlags(GAGMaterialFlags.GENERATE_CUTTING_BLADE);
        BlueSteel.addFlags(GAGMaterialFlags.GENERATE_CUTTING_BLADE);
        Ultimet.addFlags(GAGMaterialFlags.GENERATE_CUTTING_BLADE);
        TungstenCarbide.addFlags(GAGMaterialFlags.GENERATE_CUTTING_BLADE);
        HSSE.addFlags(GAGMaterialFlags.GENERATE_CUTTING_BLADE);
        NaquadahAlloy.addFlags(GAGMaterialFlags.GENERATE_CUTTING_BLADE);
        Duranium.addFlags(GAGMaterialFlags.GENERATE_CUTTING_BLADE);

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

        GagTweaks.LOGGER.info("Material modifications initialized");
    }

    private MaterialModifications() {}
}

package pismeno.gftweaks.gregtech;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconType;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class GFTOrePrefix {

    public static final List<OrePrefix> PREFIXES = new ArrayList<>();

    public static final OrePrefix chipEngraved = prefix("chipEngraved", M * 4, null, GFTMaterialIconTypes.chipEngraved,
            ENABLE_UNIFICATION, material -> material.hasFlag(GFTMaterialFlags.GENERATE_CHIPS));

    public static final OrePrefix chipRaw = prefix("chipRaw", M * 4, null, GFTMaterialIconTypes.chipRaw,
            ENABLE_UNIFICATION, material -> material.hasFlag(GFTMaterialFlags.GENERATE_CHIPS));

    public static final OrePrefix cuttingBlade = prefix("cuttingBlade", M * 4, null, GFTMaterialIconTypes.cuttingBlade,
            ENABLE_UNIFICATION, material -> material.hasFlag(GFTMaterialFlags.GENERATE_CUTTING_BLADE) && material.hasFlag(MaterialFlags.GENERATE_PLATE));

    public static final OrePrefix oreMoonRock = new OrePrefix("oreMoonRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreMarsRock = new OrePrefix("oreMarsRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreVenusRock = new OrePrefix("oreVenusRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreMercuryRock = new OrePrefix("oreMercuryRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreCeresRock = new OrePrefix("oreCeresRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreSaturnRock = new OrePrefix("oreSaturnRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreJupiterRock = new OrePrefix("oreJupiterRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreUranusRock = new OrePrefix("oreUranusRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreNeptuneRock = new OrePrefix("oreNeptuneRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix orePlutoRock = new OrePrefix("orePlutoRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreErisRock = new OrePrefix("oreErisRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreKepler22bRock = new OrePrefix("oreKepler22bRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreEuropaRock = new OrePrefix("oreEuropaRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    private GFTOrePrefix() {}

    private static OrePrefix prefix(String name, long materialAmount, Material material, MaterialIconType icon, long flags, Predicate<Material> condition) {
        OrePrefix prefix = new OrePrefix(name, materialAmount, material, icon, flags, condition);
        PREFIXES.add(prefix);
        return prefix;
    }
}

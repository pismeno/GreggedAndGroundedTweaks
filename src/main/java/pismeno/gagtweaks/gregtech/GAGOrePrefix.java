package pismeno.gagtweaks.gregtech;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconType;
import gregtech.api.unification.ore.OrePrefix;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class GAGOrePrefix {

    public static final List<OrePrefix> PREFIXES = new ArrayList<>();
    public static final List<OrePrefix> ORE_PREFIXES = new ArrayList<>();

    public static final OrePrefix chipEngraved = prefix("chipEngraved", M * 4, null, GAGMaterialIconTypes.chipEngraved,
            ENABLE_UNIFICATION, material -> material.hasFlag(GAGMaterialFlags.GENERATE_CHIPS));

    public static final OrePrefix chipRaw = prefix("chipRaw", M * 4, null, GAGMaterialIconTypes.chipRaw,
            ENABLE_UNIFICATION, material -> material.hasFlag(GAGMaterialFlags.GENERATE_CHIPS));

    public static final OrePrefix cuttingBlade = prefix("cuttingBlade", M * 4, null, GAGMaterialIconTypes.cuttingBlade,
            ENABLE_UNIFICATION, material -> material.hasFlag(GAGMaterialFlags.GENERATE_CUTTING_BLADE) && material.hasFlag(MaterialFlags.GENERATE_PLATE));

    public static final OrePrefix oreMoonRock = orePrefix("oreMoonRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreMarsRock = orePrefix("oreMarsRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreVenusRock = orePrefix("oreVenusRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreMercuryRock = orePrefix("oreMercuryRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreCeresRock = orePrefix("oreCeresRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreSaturnRock = orePrefix("oreSaturnRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreJupiterRock = orePrefix("oreJupiterRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreUranusRock = orePrefix("oreUranusRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreNeptuneRock = orePrefix("oreNeptuneRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix orePlutoRock = orePrefix("orePlutoRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreErisRock = orePrefix("oreErisRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreKepler22bRock = orePrefix("oreKepler22bRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreEuropaRock = orePrefix("oreEuropaRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreCallistoRock = orePrefix("oreCallistoRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreIoRock = orePrefix("oreIoRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreGanymedeRock = orePrefix("oreGanymedeRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreRheaRock = orePrefix("oreRheaRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreTitanRock = orePrefix("oreTitanRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreIapetusRock = orePrefix("oreIapetusRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix orePhobosRock = orePrefix("orePhobosRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreDeimosRock = orePrefix("oreDeimosRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreTritonRock = orePrefix("oreTritonRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreOberonRock = orePrefix("oreOberonRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreTitaniaRock = orePrefix("oreTitaniaRock", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreFieryNetherrack = orePrefix("oreFieryNetherrack", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreLivelyNetherrack = orePrefix("oreLivelyNetherrack", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix oreGloomyNetherrack = orePrefix("oreGloomyNetherrack", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, OrePrefix.Conditions.hasOreProperty);

    private GAGOrePrefix() {}

    private static OrePrefix prefix(String name, long materialAmount, Material material, MaterialIconType icon, long flags, Predicate<Material> condition) {
        OrePrefix prefix = new OrePrefix(name, materialAmount, material, icon, flags, condition);
        PREFIXES.add(prefix);
        return prefix;
    }

    private static OrePrefix orePrefix(String name, long materialAmount, Material material, MaterialIconType icon, long flags, Predicate<Material> condition) {
        OrePrefix prefix = new OrePrefix(name, materialAmount, material, icon, flags, condition);
        ORE_PREFIXES.add(prefix);
        return prefix;
    }
}

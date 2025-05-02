package pismeno.gagtweaks.tconstruct;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.BowStringMaterialStats;
import slimeknights.tconstruct.library.materials.Material;

import java.util.ArrayList;
import java.util.List;

public class GAGTcMaterials {

    private GAGTcMaterials() {}

    public static final List<Material> MATERIALS = new ArrayList<>();

    public static final Material HEMP = addMaterial("hemp", 9145203);

    private static void setRepresentatives() {
        Item hemp = ForgeRegistries.ITEMS.getValue(new ResourceLocation("betterwithmods", "rope"));

        HEMP.addItem(hemp, 1, Material.VALUE_Ingot);
        HEMP.setRepresentativeItem(hemp);
    }

    private static void setProperties() {
        HEMP.setCraftable(true);
    }

    private static void setStats() {
        TinkerRegistry.addMaterialStats(HEMP, new BowStringMaterialStats(1.1F));
    }

    public static void preInit() {
        MATERIALS.forEach(TinkerRegistry::addMaterial);
        setStats();
    }

    public static void init() {
        setProperties();
        setRepresentatives();
    }

    private static Material addMaterial(String name, int color) {
        Material material = new Material(name, color);
        MATERIALS.add(material);

        return material;
    }
}

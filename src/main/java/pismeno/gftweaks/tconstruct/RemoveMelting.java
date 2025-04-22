package pismeno.gftweaks.tconstruct;

import gregtech.api.unification.material.Material;
import pismeno.gregstinkering.common.recipes.MeltingRecipes;
import pismeno.gregstinkering.unification.GTCGregtechMaterials;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RemoveMelting {
    public static void init() {
        try {
            Field field = MeltingRecipes.class.getDeclaredField("arditeOres");
            field.setAccessible(true);

            Map<Integer, List<Material>> arditeOres = (Map<Integer, List<Material>>) field.get(null);

            arditeOres.remove(1, Arrays.asList(GTCGregtechMaterials.Ardite));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
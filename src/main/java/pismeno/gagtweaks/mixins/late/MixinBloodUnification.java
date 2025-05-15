package pismeno.gagtweaks.mixins.late;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtechfoodoption.GTFOMaterialHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static gregtechfoodoption.GTFOMaterialHandler.gtfoId;

@Mixin(
        value = {GTFOMaterialHandler.class},
        remap = false
)
public class MixinBloodUnification {
    /**
     * @author PismenoK
     * @reason Needs to remove "gtfo_" from id to unify with tcontruct.
     */
    @Overwrite
    public static Material.Builder fluidBuilder(int id, String name, int temp) {
        if (id == 21569) {
            return (new Material.Builder(id, gtfoId(name))).liquid((new FluidBuilder()).temperature(temp));
        } else {
            return (new Material.Builder(id, gtfoId("gtfo_" + name))).liquid((new FluidBuilder()).temperature(temp));
        }
    }
}

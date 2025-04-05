package pismeno.gftweaks;

import gregtech.api.unification.material.event.MaterialEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pismeno.gftweaks.gregtech.MaterialModifications;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public final class EventHandler {

    private EventHandler() {}

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onMaterialRegistration(MaterialEvent event) {
        MaterialModifications.init();
    }
}

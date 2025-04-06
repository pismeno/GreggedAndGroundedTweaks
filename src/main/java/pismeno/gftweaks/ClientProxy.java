package pismeno.gftweaks;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import pismeno.gftweaks.galacticraft.SchematicT1;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        GfTweaks.LOGGER.info("Pre init done");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        GfTweaks.LOGGER.info("Init done");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);

        SchematicT1.registerTextures();
        GfTweaks.LOGGER.info("Post init done");
    }
}

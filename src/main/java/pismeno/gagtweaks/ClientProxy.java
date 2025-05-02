package pismeno.gagtweaks;

import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import pismeno.gagtweaks.client.GAGTextures;
import pismeno.gagtweaks.common.GAGBlocks;
import pismeno.gagtweaks.common.GAGItems;

@Mod.EventBusSubscriber(modid = Tags.MODID, value = Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        GAGTextures.preInit();

        GagTweaks.LOGGER.info("Pre init done");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        GagTweaks.LOGGER.info("Init done");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);

        GagTweaks.LOGGER.info("Post init done");
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GAGBlocks.registerModels();
        GAGItems.registerModels();
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void openGui(GuiOpenEvent event) {
        //GFTGuiWorldSelection.init(event);
    }
}

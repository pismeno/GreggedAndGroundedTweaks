package pismeno.gftweaks;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import pismeno.gftweaks.client.GFTTextures;
import pismeno.gftweaks.common.GFTBlocks;
import pismeno.gftweaks.common.GFTItems;

@Mod.EventBusSubscriber(modid = Tags.MODID, value = Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        GFTTextures.preInit();

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

        GfTweaks.LOGGER.info("Post init done");
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GFTBlocks.registerModels();
        GFTItems.registerModels();
    }
}

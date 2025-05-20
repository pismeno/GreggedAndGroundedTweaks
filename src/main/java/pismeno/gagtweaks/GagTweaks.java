package pismeno.gagtweaks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pismeno.gagtweaks.galacticraft.DungeonLoot;

@Mod(
        modid = Tags.MODID,
        version = Tags.VERSION,
        name = Tags.MODNAME,
        acceptedMinecraftVersions = "[1.12.2]",
        dependencies =  "required-after:gregtech;" +
                        "required-after:tconstruct;" +
                        "required-after:gregstinkering;" +
                        "required-after:galacticraftcore;" +
                        "required-after:galacticraftplanets;" +
                        "required-after:extraplanets;" +
                        "required-after:betterwithmods;" +
                        "required-after:actuallyadditions;" +
                        "required-after:gregtechfoodoption;" +
                        "required:netherex"
)
public class GagTweaks {

    @SidedProxy(clientSide = "pismeno.gagtweaks.ClientProxy", serverSide = "pismeno.gagtweaks.CommonProxy")
    public static CommonProxy proxy;

    public static final Logger LOGGER = LogManager.getLogger(Tags.MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("I am " + Tags.MODNAME + " + at version " + Tags.VERSION);
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @EventHandler
    public void postInitSafe(FMLPostInitializationEvent event) throws NoSuchFieldException, IllegalAccessException {
        DungeonLoot.init();
    }
}
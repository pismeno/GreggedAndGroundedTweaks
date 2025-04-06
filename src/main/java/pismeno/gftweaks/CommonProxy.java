package pismeno.gftweaks;


import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import pismeno.gftweaks.common.GFTItems;
import pismeno.gftweaks.galacticraft.SchematicT1;
import pismeno.gftweaks.tconstruct.TcMaterials;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        TcMaterials.preInit();
        GFTItems.init();
    }

    public void init(FMLInitializationEvent event) {
        TcMaterials.init();
    }

    public void postInit(FMLPostInitializationEvent event) {
        SchematicT1.registerSchematicItems();
    }
}

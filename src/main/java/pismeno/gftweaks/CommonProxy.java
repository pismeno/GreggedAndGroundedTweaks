package pismeno.gftweaks;


import gregtech.api.unification.material.event.MaterialEvent;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pismeno.gftweaks.common.GFTItems;
import pismeno.gftweaks.gregtech.MachineRecipes;
import pismeno.gftweaks.gregtech.MaterialModifications;
import pismeno.gftweaks.tconstruct.TcMaterials;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        TcMaterials.preInit();
        GFTItems.init();
    }

    public void init(FMLInitializationEvent event) {
        TcMaterials.init();
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    @SubscribeEvent
    public static void onItemRegistration(RegistryEvent.Register<Item> event) {
        GFTItems.registerItems(event);
    }

    @SubscribeEvent
    public static void onRecipeRegistration(RegistryEvent.Register<IRecipe> event) {
        MachineRecipes.init();
    }

    @SubscribeEvent
    public static void onMaterialRegistration(MaterialEvent event) {
        MaterialModifications.init();
    }
}

package pismeno.gagtweaks;

import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.api.unification.material.event.PostMaterialEvent;
import gregtech.common.items.MetaItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pismeno.gagtweaks.common.GAGBlocks;
import pismeno.gagtweaks.common.GAGItems;
import pismeno.gagtweaks.common.recipes.CraftingRecipes;
import pismeno.gagtweaks.common.recipes.MetaItemHandler;
import pismeno.gagtweaks.common.recipes.MachineRecipes;
import pismeno.gagtweaks.galacticraft.TradeListEditor;
import pismeno.gagtweaks.galacticraft.WorkbenchRecipes;
import pismeno.gagtweaks.general.OreDict;
import pismeno.gagtweaks.gregtech.GAGMaterials;
import pismeno.gagtweaks.gregtech.GAGOrePrefix;
import pismeno.gagtweaks.gregtech.GAGStoneTypes;
import pismeno.gagtweaks.gregtech.MaterialModifications;
import pismeno.gagtweaks.gregtech.metatileentities.MetaTileEntities;
import pismeno.gagtweaks.tconstruct.RemoveMelting;
import pismeno.gagtweaks.tconstruct.GAGTcMaterials;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        GAGTcMaterials.preInit();
        GAGBlocks.init();
        GAGItems.init();
        TradeListEditor.init();
        RemoveMelting.init();
    }

    public void init(FMLInitializationEvent event) {
        GAGTcMaterials.init();
        MetaTileEntities.init();
    }

    public void postInit(FMLPostInitializationEvent event) {
        MachineRecipes.postInit();
    }

    @SubscribeEvent
    public static void onItemRegistration(RegistryEvent.Register<Item> event) {
        GAGBlocks.registerItems(event);
        GAGItems.registerItems(event);
        OreDict.init();
    }

    @SubscribeEvent
    public static void onBlockRegistration(RegistryEvent.Register<Block> event) {
        GAGBlocks.registerBlocks(event);
    }

    @SubscribeEvent
    public static void onRecipeRegistration(RegistryEvent.Register<IRecipe> event) {
        MetaItemHandler.init();
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onRecipeRegistrationLate(RegistryEvent.Register<IRecipe> event) {
        CraftingRecipes.init();
        MachineRecipes.init();
        WorkbenchRecipes.init();
    }

    @SubscribeEvent
    public static void onMaterialRegistration(MaterialEvent event) {
        GAGMaterials.init();
        MaterialModifications.init();
    }

    @SubscribeEvent
    public static void onPostMaterialRegistration(PostMaterialEvent event) {
        GAGOrePrefix.PREFIXES.forEach(MetaItems::addOrePrefix);
        GAGStoneTypes.init();
    }
}
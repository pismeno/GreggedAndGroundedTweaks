package pismeno.gftweaks.gregtech;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import pismeno.gftweaks.client.GFTGuiTextures;
import stanhebben.zenscript.annotations.ZenProperty;

public class GFTRecipeMaps {

    private GFTRecipeMaps() {}

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SAW_RECIPES= new RecipeMap<>("saw", 2, 3, 0, 0,
            new SimpleRecipeBuilder().duration(40).EUt(2), false)
            .setSlotOverlay(false, false, false, GFTGuiTextures.SAW_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.INT_CIRCUIT_OVERLAY)
            .setProgressBar(GFTGuiTextures.PROGRESS_BAR_SAW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.CUT);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> LASER_FABRICATOR_RECIPES = new RecipeMap<>("laser_fabricator", 9, 1, 0, 0,
            new SimpleRecipeBuilder().duration(400).EUt(480), false)
            .setSound(GTSoundEvents.ELECTROLYZER)
            .setProgressBar(GuiTextures.CIRCUIT_OVERLAY, ProgressWidget.MoveType.VERTICAL);
}

package pismeno.gagtweaks.client;

import gregtech.api.gui.resources.SteamTexture;
import gregtech.api.gui.resources.TextureArea;

public class GAGGuiTextures {
    public static final TextureArea SAW_OVERLAY = TextureArea
            .fullImage("textures/gui/overlay/saw_overlay.png");
    public static final SteamTexture SAW_OVERLAY_STEAM = SteamTexture
            .fullImage("textures/gui/overlay/saw_overlay_%s.png");

    public static final TextureArea PROGRESS_BAR_SAW = TextureArea
            .fullImage("textures/gui/progress_bar/progress_bar_saw.png");
    public static final SteamTexture PROGRESS_BAR_SAW_STEAM = SteamTexture
            .fullImage("textures/gui/progress_bar/progress_bar_saw_%s.png");

    private GAGGuiTextures() {}
}

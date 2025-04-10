package pismeno.gftweaks.client;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;

public class GFTTextures {
    public static OrientedOverlayRenderer SAW_OVERLAY;
    public static OrientedOverlayRenderer LASER_FABRICATOR_OVERLAY;

    private GFTTextures() {}

    public static void preInit() {
        SAW_OVERLAY = new OrientedOverlayRenderer("machines/gfsaw");
        LASER_FABRICATOR_OVERLAY = new OrientedOverlayRenderer("machines/gffabricator");
    }
}
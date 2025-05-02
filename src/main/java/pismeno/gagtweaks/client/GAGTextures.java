package pismeno.gagtweaks.client;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;

public class GAGTextures {
    public static OrientedOverlayRenderer SAW_OVERLAY;
    public static OrientedOverlayRenderer LASER_FABRICATOR_OVERLAY;

    private GAGTextures() {}

    public static void preInit() {
        SAW_OVERLAY = new OrientedOverlayRenderer("machines/gfsaw");
        LASER_FABRICATOR_OVERLAY = new OrientedOverlayRenderer("machines/gffabricator");
    }
}
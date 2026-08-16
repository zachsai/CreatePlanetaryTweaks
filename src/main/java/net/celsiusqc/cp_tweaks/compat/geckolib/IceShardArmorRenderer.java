package net.celsiusqc.cp_tweaks.compat.geckolib;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class IceShardArmorRenderer extends GeoArmorRenderer<IceShardArmorItem> {
    public IceShardArmorRenderer() {
        super(new IceShardArmorModel());
    }
}

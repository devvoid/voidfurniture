package net.prismaticvoid.voidfurniture;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class VoidFurnitureClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        addBlockToCutout("white_fairy_light");
        addBlockToCutout("orange_fairy_light");
        addBlockToCutout("magenta_fairy_light");
        addBlockToCutout("light_blue_fairy_light");
        addBlockToCutout("yellow_fairy_light");
        addBlockToCutout("lime_fairy_light");
        addBlockToCutout("pink_fairy_light");
        addBlockToCutout("gray_fairy_light");
        addBlockToCutout("light_gray_fairy_light");
        addBlockToCutout("cyan_fairy_light");
        addBlockToCutout("purple_fairy_light");
        addBlockToCutout("blue_fairy_light");
        addBlockToCutout("brown_fairy_light");
        addBlockToCutout("green_fairy_light");
        addBlockToCutout("red_fairy_light");
        addBlockToCutout("black_fairy_light");

        addBlockToCutout("ink_quill");
        addBlockToCutout("plate_cookies");

        addBlockToCutout("oak_campfire");
    }

    public static void addBlockToCutout(String name) {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.get(name), RenderLayer.getCutout());
    }
}

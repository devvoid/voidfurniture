package net.prismaticvoid.voidfurniture;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.CampfireBlockEntityRenderer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class VoidFurnitureClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                BlockRegistry.BLOCKS.get("white_fairy_light"),
                BlockRegistry.BLOCKS.get("orange_fairy_light"),
                BlockRegistry.BLOCKS.get("magenta_fairy_light"),
                BlockRegistry.BLOCKS.get("light_blue_fairy_light"),
                BlockRegistry.BLOCKS.get("yellow_fairy_light"),
                BlockRegistry.BLOCKS.get("lime_fairy_light"),
                BlockRegistry.BLOCKS.get("pink_fairy_light"),
                BlockRegistry.BLOCKS.get("gray_fairy_light"),
                BlockRegistry.BLOCKS.get("light_gray_fairy_light"),
                BlockRegistry.BLOCKS.get("cyan_fairy_light"),
                BlockRegistry.BLOCKS.get("purple_fairy_light"),
                BlockRegistry.BLOCKS.get("blue_fairy_light"),
                BlockRegistry.BLOCKS.get("brown_fairy_light"),
                BlockRegistry.BLOCKS.get("green_fairy_light"),
                BlockRegistry.BLOCKS.get("red_fairy_light"),
                BlockRegistry.BLOCKS.get("black_fairy_light")
        );

        addBlockToCutout("ink_quill");
        addBlockToCutout("plate_cookies");
    }

    public static void addBlockToCutout(String name) {
        var b = BlockRegistry.BLOCKS.get(name);

        if (b == null) {
            VoidFurnitureMod.LOGGER.error("Invalid block " + name + " registered for cutout!");
        }
        BlockRenderLayerMap.INSTANCE.putBlock(b, RenderLayer.getCutout());
    }
}

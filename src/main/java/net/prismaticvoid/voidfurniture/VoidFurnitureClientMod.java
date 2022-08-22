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
                BlockRegistry.BLOCKS.get("fairy_lights/white_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/orange_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/magenta_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/light_blue_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/yellow_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/lime_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/pink_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/gray_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/light_gray_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/cyan_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/purple_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/blue_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/brown_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/green_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/red_fairy_light"),
                BlockRegistry.BLOCKS.get("fairy_lights/black_fairy_light")
        );
        //BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.OAK_CAMPFIRE, RenderLayer.getCutout());
        //BlockEntityRendererRegistry.register(BlockRegistry.CAMPFIRE_BLOCK_ENTITY, CampfireBlockEntityRenderer::new);
    }
}

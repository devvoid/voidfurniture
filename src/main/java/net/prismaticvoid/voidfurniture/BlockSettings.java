package net.prismaticvoid.voidfurniture;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;

import java.util.function.ToIntFunction;

public class BlockSettings {
    public static final FabricBlockSettings WOOD = FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f)
            .sounds(BlockSoundGroup.WOOD)
            .nonOpaque();

    public static final FabricBlockSettings CANDLESTICK = FabricBlockSettings.of(Material.METAL)
            .strength(2.0f, 3.0f)
            .nonOpaque()
            .sounds(BlockSoundGroup.METAL)
            .luminance(createLightLevelFromLitBlockState(12));

    public static final FabricBlockSettings TERRACOTTA = FabricBlockSettings.of(Material.STONE)
            .strength(1.25f, 4.2f)
            .requiresTool();

    public static final FabricBlockSettings WOOL = FabricBlockSettings.of(Material.WOOL)
            .strength(0.8f);

    public static final FabricBlockSettings FAIRY_LIGHTS = FabricBlockSettings.of(Material.GLASS).noCollision().breakInstantly().nonOpaque().luminance(12);

    public static final FabricBlockSettings PORCELAIN = FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY)
            .strength(1.8f);

    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> (Boolean)state.get(Properties.LIT) ? litLevel : 0;
    }
}
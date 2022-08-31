package net.prismaticvoid.voidfurniture;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
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
            .luminance(createLightLevelFromLitBlockState(12))
            .nonOpaque();

    public static final FabricBlockSettings WOOL = FabricBlockSettings.of(Material.WOOL)
            .strength(0.8f)
            .nonOpaque();

    public static final FabricBlockSettings TERRACOTTA = FabricBlockSettings.of(Material.STONE)
            .strength(1.25f, 4.2f);


    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> {
            return (Boolean)state.get(Properties.LIT) ? litLevel : 0;
        };
    }
}

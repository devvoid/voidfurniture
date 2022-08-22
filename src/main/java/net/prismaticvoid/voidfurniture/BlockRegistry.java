package net.prismaticvoid.voidfurniture;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class BlockRegistry {
    public static final HashMap<String, Block> BLOCKS = new HashMap<>();

    public static void init() {
        var woodBlockSettings = FabricBlockSettings.of(Material.WOOD)
                .strength(2.0f, 3.0f)
                .sounds(BlockSoundGroup.WOOD);

        registerWoodenBlock(
                "chairs/base_chair",
                woodBlockSettings.nonOpaque(),
                ChairBlock::new
        );

        registerWoodenBlock(
                "tables/base_table_center",
                woodBlockSettings.nonOpaque(),
                TableCenterBlock::new
        );

        registerWoodenBlock(
                "tables/base_table_corner",
                woodBlockSettings.nonOpaque(),
                TableCornerBlock::new
        );

        registerWoodenBlock(
                "tables/base_table_edge",
                woodBlockSettings.nonOpaque(),
                TableEdgeBlock::new
        );

        registerWoodenBlock(
                "tables/base_short_table_center",
                woodBlockSettings.nonOpaque(),
                ShortTableCenterBlock::new
        );

        registerWoodenBlock(
                "tables/base_short_table_corner",
                woodBlockSettings.nonOpaque(),
                ShortTableCornerBlock::new
        );

        registerWoodenBlock(
                "tables/base_short_table_edge",
                woodBlockSettings.nonOpaque(),
                ShortTableEdgeBlock::new
        );

        registerBlockWithItem("plant_pots/plant_pot", new Block(FabricBlockSettings.of(Material.STONE, MapColor.ORANGE).strength(1.25F, 4.2F)));

        registerDyedBlock(
                "plant_pots/base_plant_pot",
                FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_WHITE).strength(1.25F, 4.2F),
                Block::new
        );

        registerDyedBlock(
                "plant_pots/base_glazed_plant_pot",
                FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_WHITE).strength(1.4F),
                Block::new
        );

        registerDyedBlock(
                "floor_cushions/base_floor_cushion",
                FabricBlockSettings.of(Material.WOOL).strength(0.8f).noCollision(),
                (FloorCushionBlock::new)
        );

        registerBlockWithItem("book_stack", new BookStackBlock(
                FabricBlockSettings.of(Material.WOOL)
                        .breakInstantly()
                        .nonOpaque())
        );

        registerDyedBlock(
                "fairy_lights/base_fairy_light",
                FabricBlockSettings.of(Material.GLASS).noCollision().breakInstantly().nonOpaque().luminance(12),
                (FairyLightBlock::new)
        );

        registerBlockWithItem("candlesticks/gold_candlestick", new CandlestickBlock(
                FabricBlockSettings.of(Material.DECORATION)
                        .breakInstantly()
                        .nonOpaque()
                        .luminance(createLightLevelFromLitBlockState(12)))
        );

        registerDyedBlock("candlesticks/base_gold_candlestick",
                FabricBlockSettings.of(Material.DECORATION)
                        .breakInstantly()
                        .nonOpaque()
                        .luminance(createLightLevelFromLitBlockState(12)),
                CandlestickBlock::new
        );

        registerBlockWithItem("candlesticks/iron_candlestick", new CandlestickBlock(
                FabricBlockSettings.of(Material.DECORATION)
                        .breakInstantly()
                        .nonOpaque()
                        .luminance(createLightLevelFromLitBlockState(12)))
        );

        registerDyedBlock("candlesticks/base_iron_candlestick",
                FabricBlockSettings.of(Material.DECORATION)
                        .breakInstantly()
                        .nonOpaque()
                        .luminance(createLightLevelFromLitBlockState(12)),
                CandlestickBlock::new
        );

        registerWoodenBlock(
                "benches/base_bench",
                woodBlockSettings.nonOpaque(),
                BenchBlock::new
        );
    }

    private static <B extends Block> void registerWoodenBlock(String name, FabricBlockSettings settings, Function<FabricBlockSettings,B> factory) {
        String[] types = {"oak", "birch", "spruce", "jungle", "acacia", "dark_oak", "crimson", "warped"};

        for (String type : types) {
            var new_name = name.replace("base", type);

            registerBlockWithItem(new_name, factory.apply(settings));
        }
    }

    private static <B extends Block> void registerDyedBlock(String name, FabricBlockSettings settings, Function<FabricBlockSettings,B> factory) {
        String[] types = {"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};

        for (int i = 0; i < types.length; i++) {
            var new_name = name.replace("base", types[i]);

            registerBlockWithItem(new_name, factory.apply(settings.mapColor(MapColor.get(i))));
        }
    }

    private static <B extends Block> B registerBlockWithItem(String name, B block) {
        final B b = registerBlock(name, block);
        Registry.register(Registry.ITEM, Utils.id(name), new BlockItem(b, new FabricItemSettings().group(Utils.GROUP)));
        return b;
    }

    private static <B extends Block> B registerBlock(String name, B block) {
        var result = Registry.register(Registry.BLOCK, Utils.id(name), block);
        BLOCKS.put(name, result);
        return result;
    }

    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> {
            return (Boolean)state.get(Properties.LIT) ? litLevel : 0;
        };
    }
}

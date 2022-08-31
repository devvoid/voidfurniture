package net.prismaticvoid.voidfurniture;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.registry.Registry;
import net.prismaticvoid.voidfurniture.blocks.*;
import net.prismaticvoid.voidfurniture.blocks.PlateBlock;
import net.prismaticvoid.voidfurniture.blocks.TeacupBlock;
import net.prismaticvoid.voidfurniture.blocks.TeapotBlock;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class BlockRegistry {
    //region Seating
    public static final Block OAK_CHAIR = register("oak_chair", new ChairBlock(BlockSettings.WOOD));
    public static final Block BIRCH_CHAIR = register("birch_chair", new ChairBlock(BlockSettings.WOOD));
    public static final Block SPRUCE_CHAIR = register("spruce_chair", new ChairBlock(BlockSettings.WOOD));
    public static final Block JUNGLE_CHAIR = register("jungle_chair", new ChairBlock(BlockSettings.WOOD));
    public static final Block ACACIA_CHAIR = register("acacia_chair", new ChairBlock(BlockSettings.WOOD));
    public static final Block DARK_OAK_CHAIR = register("dark_oak_chair", new ChairBlock(BlockSettings.WOOD));
    public static final Block CRIMSON_CHAIR = register("crimson_chair", new ChairBlock(BlockSettings.WOOD));
    public static final Block WARPED_CHAIR = register("warped_chair", new ChairBlock(BlockSettings.WOOD));

    public static final Block WHITE_FLOOR_CUSHION = register("white_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block ORANGE_FLOOR_CUSHION = register("orange_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block MAGENTA_FLOOR_CUSHION = register("magenta_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block LIGHT_BLUE_FLOOR_CUSHION = register("light_blue_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block YELLOW_FLOOR_CUSHION = register("yellow_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block LIME_FLOOR_CUSHION = register("lime_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block PINK_FLOOR_CUSHION = register("pink_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block GRAY_FLOOR_CUSHION = register("gray_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block LIGHT_GRAY_FLOOR_CUSHION = register("light_gray_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block CYAN_FLOOR_CUSHION = register("cyan_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block PURPLE_FLOOR_CUSHION = register("purple_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block BLUE_FLOOR_CUSHION = register("blue_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block BROWN_FLOOR_CUSHION = register("brown_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block GREEN_FLOOR_CUSHION = register("green_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block RED_FLOOR_CUSHION = register("red_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));
    public static final Block BLACK_FLOOR_CUSHION = register("black_floor_cushion", new FloorCushionBlock(BlockSettings.WOOL));

    public static final Block OAK_BENCH = register("oak_bench", new BenchBlock(BlockSettings.WOOD));
    public static final Block BIRCH_BENCH = register("birch_bench", new BenchBlock(BlockSettings.WOOD));
    public static final Block SPRUCE_BENCH = register("spruce_bench", new BenchBlock(BlockSettings.WOOD));
    public static final Block JUNGLE_BENCH = register("jungle_bench", new BenchBlock(BlockSettings.WOOD));
    public static final Block ACACIA_BENCH = register("acacia_bench", new BenchBlock(BlockSettings.WOOD));
    public static final Block DARK_OAK_BENCH = register("dark_oak_bench", new BenchBlock(BlockSettings.WOOD));
    public static final Block CRIMSON_BENCH = register("crimson_bench", new BenchBlock(BlockSettings.WOOD));
    public static final Block WARPED_BENCH = register("warped_bench", new BenchBlock(BlockSettings.WOOD));

    public static final Block OAK_STOOL = register("oak_stool", new BenchBlock(BlockSettings.WOOD));
    public static final Block BIRCH_STOOL = register("birch_stool", new BenchBlock(BlockSettings.WOOD));
    public static final Block SPRUCE_STOOL = register("spruce_stool", new BenchBlock(BlockSettings.WOOD));
    public static final Block JUNGLE_STOOL = register("jungle_stool", new BenchBlock(BlockSettings.WOOD));
    public static final Block ACACIA_STOOL = register("acacia_stool", new BenchBlock(BlockSettings.WOOD));
    public static final Block DARK_OAK_STOOL = register("dark_oak_stool", new BenchBlock(BlockSettings.WOOD));
    public static final Block CRIMSON_STOOL = register("crimson_stool", new BenchBlock(BlockSettings.WOOD));
    public static final Block WARPED_STOOL = register("warped_stool", new BenchBlock(BlockSettings.WOOD));
    //endregion

    //region Tables
    public static final Block OAK_TABLE_CENTER = register("oak_table_center", new TableCenterBlock(BlockSettings.WOOD));
    public static final Block OAK_TABLE_CORNER = register("oak_table_corner", new TableCornerBlock(BlockSettings.WOOD));
    public static final Block OAK_TABLE_EDGE = register("oak_table_edge", new TableEdgeBlock(BlockSettings.WOOD));
    public static final Block BIRCH_TABLE_CENTER = register("birch_table_center", new TableCenterBlock(BlockSettings.WOOD));
    public static final Block BIRCH_TABLE_CORNER = register("birch_table_corner", new TableCornerBlock(BlockSettings.WOOD));
    public static final Block BIRCH_TABLE_EDGE = register("birch_table_edge", new TableEdgeBlock(BlockSettings.WOOD));
    public static final Block SPRUCE_TABLE_CENTER = register("spruce_table_center", new TableCenterBlock(BlockSettings.WOOD));
    public static final Block SPRUCE_TABLE_CORNER = register("spruce_table_corner", new TableCornerBlock(BlockSettings.WOOD));
    public static final Block SPRUCE_TABLE_EDGE = register("spruce_table_edge", new TableEdgeBlock(BlockSettings.WOOD));
    public static final Block JUNGLE_TABLE_CENTER = register("jungle_table_center", new TableCenterBlock(BlockSettings.WOOD));
    public static final Block JUNGLE_TABLE_CORNER = register("jungle_table_corner", new TableCornerBlock(BlockSettings.WOOD));
    public static final Block JUNGLE_TABLE_EDGE = register("jungle_table_edge", new TableEdgeBlock(BlockSettings.WOOD));
    public static final Block ACACIA_TABLE_CENTER = register("acacia_table_center", new TableCenterBlock(BlockSettings.WOOD));
    public static final Block ACACIA_TABLE_CORNER = register("acacia_table_corner", new TableCornerBlock(BlockSettings.WOOD));
    public static final Block ACACIA_TABLE_EDGE = register("acacia_table_edge", new TableEdgeBlock(BlockSettings.WOOD));
    public static final Block DARK_OAK_TABLE_CENTER = register("dark_oak_table_center", new TableCenterBlock(BlockSettings.WOOD));
    public static final Block DARK_OAK_TABLE_CORNER = register("dark_oak_table_corner", new TableCornerBlock(BlockSettings.WOOD));
    public static final Block DARK_OAK_TABLE_EDGE = register("dark_oak_table_edge", new TableEdgeBlock(BlockSettings.WOOD));
    public static final Block CRIMSON_TABLE_CENTER = register("crimson_table_center", new TableCenterBlock(BlockSettings.WOOD));
    public static final Block CRIMSON_TABLE_CORNER = register("crimson_table_corner", new TableCornerBlock(BlockSettings.WOOD));
    public static final Block CRIMSON_TABLE_EDGE = register("crimson_table_edge", new TableEdgeBlock(BlockSettings.WOOD));
    public static final Block WARPED_TABLE_CENTER = register("warped_table_center", new TableCenterBlock(BlockSettings.WOOD));
    public static final Block WARPED_TABLE_CORNER = register("warped_table_corner", new TableCornerBlock(BlockSettings.WOOD));
    public static final Block WARPED_TABLE_EDGE = register("warped_table_edge", new TableEdgeBlock(BlockSettings.WOOD));
    //endregion

    //region Plant pots
    public static final Block PLANT_POT = register("plant_pot", new Block(BlockSettings.TERRACOTTA));

    public static final Block WHITE_PLANT_POT = register("white_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.WHITE)));
    public static final Block ORANGE_PLANT_POT = register("orange_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.ORANGE)));
    public static final Block MAGENTA_PLANT_POT = register("magenta_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.MAGENTA)));
    public static final Block LIGHT_BLUE_PLANT_POT = register("light_blue_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.LIGHT_BLUE)));
    public static final Block YELLOW_PLANT_POT = register("yellow_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.YELLOW)));
    public static final Block LIME_PLANT_POT = register("lime_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.LIME)));
    public static final Block PINK_PLANT_POT = register("pink_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.PINK)));
    public static final Block GRAY_PLANT_POT = register("gray_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.GRAY)));
    public static final Block LIGHT_GRAY_PLANT_POT = register("light_gray_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.LIGHT_GRAY)));
    public static final Block CYAN_PLANT_POT = register("cyan_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.CYAN)));
    public static final Block PURPLE_PLANT_POT = register("purple_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.PURPLE)));
    public static final Block BLUE_PLANT_POT = register("blue_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.BLUE)));
    public static final Block BROWN_PLANT_POT = register("brown_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.BROWN)));
    public static final Block GREEN_PLANT_POT = register("green_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.GREEN)));
    public static final Block RED_PLANT_POT = register("red_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.RED)));
    public static final Block BLACK_PLANT_POT = register("black_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.BLACK)));

    public static final Block WHITE_GLAZED_PLANT_POT = register("white_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.WHITE)));
    public static final Block ORANGE_GLAZED_PLANT_POT = register("orange_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.ORANGE)));
    public static final Block MAGENTA_GLAZED_PLANT_POT = register("magenta_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.MAGENTA)));
    public static final Block LIGHT_BLUE_GLAZED_PLANT_POT = register("light_blue_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.LIGHT_BLUE)));
    public static final Block YELLOW_GLAZED_PLANT_POT = register("yellow_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.YELLOW)));
    public static final Block LIME_GLAZED_PLANT_POT = register("lime_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.LIME)));
    public static final Block PINK_GLAZED_PLANT_POT = register("pink_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.PINK)));
    public static final Block GRAY_GLAZED_PLANT_POT = register("gray_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.GRAY)));
    public static final Block LIGHT_GRAY_GLAZED_PLANT_POT = register("light_gray_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.LIGHT_GRAY)));
    public static final Block CYAN_GLAZED_PLANT_POT = register("cyan_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.CYAN)));
    public static final Block PURPLE_GLAZED_PLANT_POT = register("purple_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.PURPLE)));
    public static final Block BLUE_GLAZED_PLANT_POT = register("blue_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.BLUE)));
    public static final Block BROWN_GLAZED_PLANT_POT = register("brown_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.BROWN)));
    public static final Block GREEN_GLAZED_PLANT_POT = register("green_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.GREEN)));
    public static final Block RED_GLAZED_PLANT_POT = register("red_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.RED)));
    public static final Block BLACK_GLAZED_PLANT_POT = register("black_plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.BLACK)));
    //endregion

    public static void init() {
        registerBlockWithItem("book_stack", new BookStackBlock(
                FabricBlockSettings.of(Material.WOOL)
                        .breakInstantly()
                        .nonOpaque())
        );

        registerDyedBlock(
                "base_fairy_light",
                FabricBlockSettings.of(Material.GLASS).noCollision().breakInstantly().nonOpaque().luminance(12),
                (FairyLightBlock::new)
        );

        registerBlock("gold_candlestick", new CandlestickBlock(candlestickBlockSettings));

        registerBlock("gold_wall_candlestick", new CandlestickWallBlock(candlestickBlockSettings));

        registerBlock("iron_candlestick", new CandlestickBlock(candlestickBlockSettings));

        registerBlock("iron_wall_candlestick", new CandlestickWallBlock(candlestickBlockSettings));

        registerDyedBlock("base_gold_candlestick",
                candlestickBlockSettings,
                CandlestickBlock::new,
                false
        );

        registerDyedBlock("base_gold_wall_candlestick",
                candlestickBlockSettings,
                CandlestickWallBlock::new,
                false
        );

        registerDyedBlock("base_iron_candlestick",
                candlestickBlockSettings,
                CandlestickBlock::new,
                false
        );

        registerDyedBlock("base_iron_wall_candlestick",
                candlestickBlockSettings,
                CandlestickWallBlock::new,
                false
        );

        registerBlockWithItem("brick_chimney", new ChimneyBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.RED).strength(2.0f, 6.0f).requiresTool()
        ));

        registerBlockWithItem("ink_quill", new InkQuillBlock(
                FabricBlockSettings.of(Material.DECORATION).breakInstantly()
        ));

        registerBlockWithItem("teapot", new TeapotBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY).strength(1.8f)
        ));

        registerBlockWithItem("teacup", new TeacupBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY).strength(1.8f)
        ));

        registerBlockWithItem("plate_empty", new PlateBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY).strength(1.8f)
        ));

        registerBlockWithItem("plate_cookies", new PlateBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY).strength(1.8f)
        ));

        registerBlockWithItem("plate_sandwich", new PlateBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY).strength(1.8f)
        ));

        registerBlockWithItem("trunk", new TrunkBlock(
                woodBlockSettings
        ));
    }

    public static <B extends Block> B register(String name, B block) {
        register(name, block, true);
    }

    public static <B extends Block> B register(String name, B block, boolean itemToo) {
        var b = Registry.register(Registry.BLOCK, Utils.id(name), block);

        if (itemToo) {
            Registry.register(Registry.ITEM, Utils.id(name), new BlockItem(block, ItemSettings.GROUP));
        }

        return block;
    }
}

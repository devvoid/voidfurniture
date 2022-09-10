package net.prismaticvoid.voidfurniture;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.util.registry.Registry;
import net.prismaticvoid.voidfurniture.blocks.*;

import java.util.HashMap;
import java.util.function.Function;

public class BlockRegistry {
    public static final HashMap<String, Block> BLOCKS = new HashMap<>();

    public static void init() {
        registerWoodenBlock(
                "base_chair",
                BlockSettings.WOOD.nonOpaque(),
                ChairBlock::new
        );

        registerWoodenBlock(
                "base_table_center",
                BlockSettings.WOOD.nonOpaque(),
                TableCenterBlock::new
        );

        registerWoodenBlock(
                "base_table_corner",
                BlockSettings.WOOD.nonOpaque(),
                TableCornerBlock::new
        );

        registerWoodenBlock(
                "base_table_edge",
                BlockSettings.WOOD.nonOpaque(),
                TableEdgeBlock::new
        );

        registerBlockWithItem("plant_pot", new Block(BlockSettings.TERRACOTTA.mapColor(MapColor.TERRACOTTA_ORANGE)));

        registerDyedBlock(
                "base_plant_pot",
                BlockSettings.TERRACOTTA,
                Block::new
        );

        registerDyedBlock(
                "base_glazed_plant_pot",
                BlockSettings.TERRACOTTA,
                Block::new
        );

        registerDyedBlock(
                "base_floor_cushion",
                BlockSettings.WOOL.noCollision(),
                (FloorCushionBlock::new)
        );

        registerBlockWithItem("book_stack", new BookStackBlock(
                FabricBlockSettings.of(Material.DECORATION)
                        .breakInstantly()
                        .nonOpaque())
        );

        registerDyedBlock(
                "base_fairy_light",
                BlockSettings.FAIRY_LIGHTS,
                (FairyLightBlock::new)
        );

        registerBlock("gold_candlestick", new CandlestickBlock(BlockSettings.CANDLESTICK));

        registerBlock("gold_wall_candlestick", new CandlestickWallBlock(BlockSettings.CANDLESTICK));

        registerDyedBlock("base_gold_candlestick",
                BlockSettings.CANDLESTICK,
                CandlestickBlock::new,
                false
        );

        registerDyedBlock("base_gold_wall_candlestick",
                BlockSettings.CANDLESTICK,
                CandlestickWallBlock::new,
                false
        );

        registerBlock("iron_candlestick", new CandlestickBlock(BlockSettings.CANDLESTICK));

        registerBlock("iron_wall_candlestick", new CandlestickWallBlock(BlockSettings.CANDLESTICK));

        registerDyedBlock("base_iron_candlestick",
                BlockSettings.CANDLESTICK,
                CandlestickBlock::new,
                false
        );

        registerDyedBlock("base_iron_wall_candlestick",
                BlockSettings.CANDLESTICK,
                CandlestickWallBlock::new,
                false
        );


        registerWoodenBlock(
                "base_bench",
                BlockSettings.WOOD.nonOpaque(),
                BenchBlock::new
        );

        registerBlockWithItem("brick_chimney", new ChimneyBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.RED).strength(2.0f, 6.0f).requiresTool()
        ));

        registerBlockWithItem("ink_quill", new InkQuillBlock(
                FabricBlockSettings.of(Material.DECORATION).breakInstantly()
        ));

        registerWoodenBlock("base_stool", BlockSettings.WOOD, StoolBlock::new);

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

        registerBlockWithItem("trunk", new TrunkBlock(BlockSettings.WOOD));

        registerBlockWithItem("oak_campfire", new ModdedCampfireBlock(true, 1, BlockSettings.CAMPFIRE));
        registerBlockWithItem("birch_campfire", new ModdedCampfireBlock(true, 1, BlockSettings.CAMPFIRE));
        registerBlockWithItem("spruce_campfire", new ModdedCampfireBlock(true, 1, BlockSettings.CAMPFIRE));
        registerBlockWithItem("jungle_campfire", new ModdedCampfireBlock(true, 1, BlockSettings.CAMPFIRE));
        registerBlockWithItem("acacia_campfire", new ModdedCampfireBlock(true, 1, BlockSettings.CAMPFIRE));
        registerBlockWithItem("dark_oak_campfire", new ModdedCampfireBlock(true, 1, BlockSettings.CAMPFIRE));
        registerBlockWithItem("crimson_campfire", new ModdedCampfireBlock(true, 1, BlockSettings.CAMPFIRE));
        registerBlockWithItem("warped_campfire", new ModdedCampfireBlock(true, 1, BlockSettings.CAMPFIRE));

        registerBlockWithItem("oak_soul_campfire", new ModdedCampfireBlock(false, 2, BlockSettings.SOUL_CAMPFIRE));
        registerBlockWithItem("birch_soul_campfire", new ModdedCampfireBlock(false, 2, BlockSettings.SOUL_CAMPFIRE));
        registerBlockWithItem("spruce_soul_campfire", new ModdedCampfireBlock(false, 2, BlockSettings.SOUL_CAMPFIRE));
        registerBlockWithItem("jungle_soul_campfire", new ModdedCampfireBlock(false, 2, BlockSettings.SOUL_CAMPFIRE));
        registerBlockWithItem("acacia_soul_campfire", new ModdedCampfireBlock(false, 2, BlockSettings.SOUL_CAMPFIRE));
        registerBlockWithItem("dark_oak_soul_campfire", new ModdedCampfireBlock(false, 2, BlockSettings.SOUL_CAMPFIRE));
        registerBlockWithItem("crimson_soul_campfire", new ModdedCampfireBlock(false, 2, BlockSettings.SOUL_CAMPFIRE));
        registerBlockWithItem("warped_soul_campfire", new ModdedCampfireBlock(false, 2, BlockSettings.SOUL_CAMPFIRE));
    }

    public static Block get(String name) {
        return BLOCKS.get(name);
    }

    private static <B extends Block> void registerWoodenBlock(String name, FabricBlockSettings settings, Function<FabricBlockSettings,B> factory) {
        registerWoodenBlock(name, settings, factory, true);
    }

    private static <B extends Block> void registerWoodenBlock(String name, FabricBlockSettings settings, Function<FabricBlockSettings,B> factory, boolean addItemToo) {
        String[] types = {"oak", "birch", "spruce", "jungle", "acacia", "dark_oak", "crimson", "warped"};

        for (String type : types) {
            var new_name = name.replace("base", type);

            if (addItemToo) {
                registerBlockWithItem(new_name, factory.apply(settings));
            }
            else {
                registerBlock(new_name, factory.apply(settings));
            }
        }
    }

    private static <B extends Block> void registerDyedBlock(String name, FabricBlockSettings settings, Function<FabricBlockSettings,B> factory) {
        registerDyedBlock(name, settings, factory, true);
    }

    private static <B extends Block> void registerDyedBlock(String name, FabricBlockSettings settings, Function<FabricBlockSettings,B> factory, boolean addItemToo) {
        String[] types = {"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};

        for (int i = 0; i < types.length; i++) {
            var new_name = name.replace("base", types[i]);

            if (addItemToo) {
                registerBlockWithItem(new_name, factory.apply(settings.mapColor(MapColor.get(i))));
            }
            else {
                registerBlock(new_name, factory.apply(settings.mapColor(MapColor.get(i))));
            }
        }
    }

    private static <B extends Block> B registerBlockWithItem(String name, B block) {
        final B b = registerBlock(name, block);
        var i = Registry.register(Registry.ITEM, Utils.id(name), new BlockItem(b, new FabricItemSettings().group(Utils.GROUP)));
        ItemRegistry.ITEMS.put(name, i);
        return b;
    }

    private static <B extends Block> B registerBlock(String name, B block) {
        var result = Registry.register(Registry.BLOCK, Utils.id(name), block);
        BLOCKS.put(name, result);
        return result;
    }
}

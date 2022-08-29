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
    public static final HashMap<String, Block> BLOCKS = new HashMap<>();

    public static void init() {
        var woodBlockSettings = FabricBlockSettings.of(Material.WOOD)
                .strength(2.0f, 3.0f)
                .sounds(BlockSoundGroup.WOOD);

        var candlestickBlockSettings = FabricBlockSettings.of(Material.METAL)
            .strength(2.0f, 3.0f)
            .nonOpaque()
            .sounds(BlockSoundGroup.METAL)
            .luminance(createLightLevelFromLitBlockState(12));

        registerWoodenBlock(
                "seating/chairs/base_chair",
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

        registerBlockWithItem("plant_pots/plant_pot", new Block(
                FabricBlockSettings.of(Material.STONE, MapColor.ORANGE).strength(1.25F, 4.2F)
        ));

        registerDyedBlock(
                "plant_pots/base_plant_pot",
                FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_WHITE).strength(1.25F, 4.2F).requiresTool(),
                Block::new
        );

        registerDyedBlock(
                "plant_pots/base_glazed_plant_pot",
                FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_WHITE).strength(1.4F, 4.2F).requiresTool(),
                Block::new
        );

        registerDyedBlock(
                "seating/floor_cushions/base_floor_cushion",
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

        registerBlock("candlesticks/gold_candlestick", new CandlestickBlock(candlestickBlockSettings));

        registerBlock("candlesticks/gold_wall_candlestick", new CandlestickWallBlock(candlestickBlockSettings));

        registerBlock("candlesticks/iron_candlestick", new CandlestickBlock(candlestickBlockSettings));

        registerBlock("candlesticks/iron_wall_candlestick", new CandlestickWallBlock(candlestickBlockSettings));

        registerDyedBlock("candlesticks/base_gold_candlestick",
                candlestickBlockSettings,
                CandlestickBlock::new,
                false
        );

        registerDyedBlock("candlesticks/base_gold_wall_candlestick",
                candlestickBlockSettings,
                CandlestickWallBlock::new,
                false
        );

        registerDyedBlock("candlesticks/base_iron_candlestick",
                candlestickBlockSettings,
                CandlestickBlock::new,
                false
        );

        registerDyedBlock("candlesticks/base_iron_wall_candlestick",
                candlestickBlockSettings,
                CandlestickWallBlock::new,
                false
        );


        registerWoodenBlock(
                "seating/benches/base_bench",
                woodBlockSettings.nonOpaque(),
                BenchBlock::new
        );

        registerBlockWithItem("chimneys/brick_chimney", new ChimneyBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.RED).strength(2.0f, 6.0f).requiresTool()
        ));

        registerBlockWithItem("ink_quill", new InkQuillBlock(
                FabricBlockSettings.of(Material.DECORATION).breakInstantly()
        ));

        registerWoodenBlock("seating/stools/base_stool", woodBlockSettings, StoolBlock::new);

        registerBlockWithItem("teatime/teapot", new TeapotBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY).strength(1.8f)
        ));

        registerBlockWithItem("teatime/teacup", new TeacupBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY).strength(1.8f)
        ));

        registerBlockWithItem("teatime/plate_empty", new PlateBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY).strength(1.8f)
        ));

        registerBlockWithItem("teatime/plate_cookies", new PlateBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY).strength(1.8f)
        ));

        registerBlockWithItem("teatime/plate_sandwich", new PlateBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.WHITE_GRAY).strength(1.8f)
        ));

        registerBlockWithItem("misc/trunk", new TrunkBlock(
                woodBlockSettings
        ));
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

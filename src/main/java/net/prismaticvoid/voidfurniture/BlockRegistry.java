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
        //region Seating
        registerWoodenBlock("base_chair", BlockSettings.WOOD.nonOpaque(), ChairBlock::new);

        registerWoodenBlock("base_bench", BlockSettings.WOOD.nonOpaque(), BenchBlock::new);

        registerWoodenBlock("base_stool", BlockSettings.WOOD.nonOpaque(), StoolBlock::new);

        registerDyedBlock("base_floor_cushion", BlockSettings.WOOL.nonOpaque().noCollision(), FloorCushionBlock::new);
        //endregion

        //region Tables
        registerWoodenBlock("base_table_center", BlockSettings.WOOD.nonOpaque(), TableCenterBlock::new);

        registerWoodenBlock("base_table_corner", BlockSettings.WOOD.nonOpaque(), TableCornerBlock::new);

        registerWoodenBlock("base_table_edge", BlockSettings.WOOD.nonOpaque(), TableEdgeBlock::new);
        //endregion

        //region Plant Pots
        registerBlockWithItem("plant_pot", new Block(BlockSettings.TERRACOTTA));

        registerDyedBlock("base_plant_pot", BlockSettings.TERRACOTTA, Block::new);

        registerDyedBlock("base_glazed_plant_pot", BlockSettings.TERRACOTTA, Block::new);
        //endregion

        /*
        //region Lighting
        registerDyedBlock("base_fairy_light", BlockSettings.FAIRY_LIGHTS, (FairyLightBlock::new));

        registerBlock("gold_candlestick", new CandlestickBlock(BlockSettings.CANDLESTICK));

        registerBlock("gold_wall_candlestick", new CandlestickWallBlock(BlockSettings.CANDLESTICK));

        registerBlock("iron_candlestick", new CandlestickBlock(BlockSettings.CANDLESTICK));

        registerBlock("iron_wall_candlestick", new CandlestickWallBlock(BlockSettings.CANDLESTICK));

        registerDyedBlock("base_gold_candlestick", BlockSettings.CANDLESTICK, CandlestickBlock::new, false);

        registerDyedBlock("base_gold_wall_candlestick", BlockSettings.CANDLESTICK, CandlestickWallBlock::new, false);

        registerDyedBlock("base_iron_candlestick", BlockSettings.CANDLESTICK, CandlestickBlock::new, false);

        registerDyedBlock("base_iron_wall_candlestick", BlockSettings.CANDLESTICK, CandlestickWallBlock::new, false);
        //endregion

        //region Chimneys
        registerBlockWithItem("brick_chimney", new ChimneyBlock(
                FabricBlockSettings.of(Material.STONE, MapColor.RED).strength(2.0f, 6.0f).requiresTool()
        ));
        //endregion

        //region Misc
        registerBlockWithItem("book_stack", new BookStackBlock(
                FabricBlockSettings.of(Material.WOOL)
                        .breakInstantly()
                        .nonOpaque())
        );

        registerBlockWithItem("ink_quill", new InkQuillBlock(
                FabricBlockSettings.of(Material.DECORATION).breakInstantly()
        ));

        registerBlockWithItem("teapot", new TeapotBlock(BlockSettings.PORCELAIN.nonOpaque()));

        registerBlockWithItem("teacup", new TeacupBlock(BlockSettings.PORCELAIN.nonOpaque()));

        registerBlockWithItem("plate_empty", new PlateBlock(BlockSettings.PORCELAIN.nonOpaque()));

        registerBlockWithItem("plate_cookies", new PlateBlock(BlockSettings.PORCELAIN.nonOpaque()));

        registerBlockWithItem("plate_sandwich", new PlateBlock(BlockSettings.PORCELAIN.nonOpaque()));

        registerBlockWithItem("trunk", new TrunkBlock(BlockSettings.WOOD.nonOpaque()));
        //endregion
        */
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

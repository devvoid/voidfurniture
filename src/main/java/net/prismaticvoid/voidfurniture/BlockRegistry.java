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
    // Chairs



    // Campfires
/*    public static final BlockEntityType<CampfireBlockEntity> CAMPFIRE_BLOCK_ENTITY;

    public static final CampfireBlock OAK_CAMPFIRE = registerBlockWithItem("oak_campfire", new CampfireBlock(true, 1,
            FabricBlockSettings.of(Material.WOOD, MapColor.SPRUCE_BROWN).nonOpaque().strength(2.0F).sounds(BlockSoundGroup.WOOD).luminance(createLightLevelFromLitBlockState(15))));
            */


    static {
        /*
        CAMPFIRE_BLOCK_ENTITY = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                new Identifier("voidfurniture", "campfire"),
                FabricBlockEntityTypeBuilder.create(CampfireBlockEntity::new, OAK_CAMPFIRE).build()
        );
         */
    }

    public static void init() {
        registerWoodenBlock(
                "chair",
                FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque(),
                ChairBlock::new
        );

        registerWoodenBlock(
                "table_center",
                FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque(),
                TableCenterBlock::new
        );

        registerWoodenBlock(
                "table_corner",
                FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque(),
                TableCornerBlock::new
        );

        registerWoodenBlock(
                "table_edge",
                FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque(),
                TableEdgeBlock::new
        );

        BLOCKS.put("plant_pot", registerBlockWithItem("plant_pot", new Block(FabricBlockSettings.of(Material.STONE, MapColor.ORANGE).strength(1.25F, 4.2F))));

        registerDyedBlock(
                "plant_pot",
                FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_WHITE).strength(1.25F, 4.2F),
                Block::new
        );

        registerDyedBlock(
                "floor_cushion",
                FabricBlockSettings.of(Material.WOOL).strength(0.8f),
                (FloorCushionBlock::new)
        );
    }

    private static <B extends Block> void registerWoodenBlock(String name, FabricBlockSettings settings, Function<FabricBlockSettings,B> factory) {
        String[] types = {"oak", "birch", "spruce", "jungle", "acacia", "dark_oak", "crimson", "warped"};

        for (int i = 0; i < types.length; i++) {
            var new_name = types[i] + "_" + name;

            registerBlockWithItem(new_name, factory.apply(settings.mapColor(MapColor.get(i))));
        }
    }

    private static <B extends Block> void registerDyedBlock(String name, FabricBlockSettings settings, Function<FabricBlockSettings,B> factory) {
        String[] types = {"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};

        for (int i = 0; i < types.length; i++) {
            var new_name = types[i] + "_" + name;

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

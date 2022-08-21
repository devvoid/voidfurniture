package net.prismaticvoid.voidfurniture;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.LoggerFactory;

import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.logging.Logger;

public class BlockRegistry {
    // Chairs
    public static final ChairBlock OAK_CHAIR = registerBlockWithItem("oak_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock BIRCH_CHAIR = registerBlockWithItem("birch_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock SPRUCE_CHAIR = registerBlockWithItem("spruce_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock JUNGLE_CHAIR = registerBlockWithItem("jungle_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock ACACIA_CHAIR = registerBlockWithItem("acacia_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock DARK_OAK_CHAIR = registerBlockWithItem("dark_oak_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock CRIMSON_CHAIR = registerBlockWithItem("crimson_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock WARPED_CHAIR = registerBlockWithItem("warped_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    // Tables
    public static final Block OAK_TABLE_CENTER = registerBlockWithItem("oak_table_center",
            new TableCenterBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final TableCornerBlock OAK_TABLE_CORNER = registerBlockWithItem("oak_table_corner",
            new TableCornerBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final Block BIRCH_TABLE_CENTER = registerBlockWithItem("birch_table_center",
            new TableCenterBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final TableCornerBlock BIRCH_TABLE_CORNER = registerBlockWithItem("birch_table_corner",
            new TableCornerBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final Block SPRUCE_TABLE_CENTER = registerBlockWithItem("spruce_table_center",
            new TableCenterBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final TableCornerBlock SPRUCE_TABLE_CORNER = registerBlockWithItem("spruce_table_corner",
            new TableCornerBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final Block JUNGLE_TABLE_CENTER = registerBlockWithItem("jungle_table_center",
            new TableCenterBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final TableCornerBlock JUNGLE_TABLE_CORNER = registerBlockWithItem("jungle_table_corner",
            new TableCornerBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final Block ACACIA_TABLE_CENTER = registerBlockWithItem("acacia_table_center",
            new TableCenterBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final TableCornerBlock ACACIA_TABLE_CORNER = registerBlockWithItem("acacia_table_corner",
            new TableCornerBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final Block DARK_OAK_TABLE_CENTER = registerBlockWithItem("dark_oak_table_center",
            new TableCenterBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final TableCornerBlock DARK_OAK_TABLE_CORNER = registerBlockWithItem("dark_oak_table_corner",
            new TableCornerBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final Block CRIMSON_TABLE_CENTER = registerBlockWithItem("crimson_table_center",
            new TableCenterBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final TableCornerBlock CRIMSON_TABLE_CORNER = registerBlockWithItem("crimson_table_corner",
            new TableCornerBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final Block WARPED_TABLE_CENTER = registerBlockWithItem("warped_table_center",
            new TableCenterBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final TableCornerBlock WARPED_TABLE_CORNER = registerBlockWithItem("warped_table_corner",
            new TableCornerBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    // Campfires
/*    public static final BlockEntityType<CampfireBlockEntity> CAMPFIRE_BLOCK_ENTITY;

    public static final CampfireBlock OAK_CAMPFIRE = registerBlockWithItem("oak_campfire", new CampfireBlock(true, 1,
            FabricBlockSettings.of(Material.WOOD, MapColor.SPRUCE_BROWN).nonOpaque().strength(2.0F).sounds(BlockSoundGroup.WOOD).luminance(createLightLevelFromLitBlockState(15))));
            */

    // Misc
    public static final Block PLANT_POT = registerBlockWithItem("plant_pot",
            new Block(FabricBlockSettings.of(Material.STONE, MapColor.ORANGE).strength(1.25F, 4.2F))
    );

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
        registerDyedBlock(
                "plant_pot",
                FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_WHITE).strength(1.25F, 4.2F),
                (fabricBlockSettings) -> {return new Block(fabricBlockSettings);}
        );
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
        return Registry.register(Registry.BLOCK, Utils.id(name), block);
    }

    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> {
            return (Boolean)state.get(Properties.LIT) ? litLevel : 0;
        };
    }
}

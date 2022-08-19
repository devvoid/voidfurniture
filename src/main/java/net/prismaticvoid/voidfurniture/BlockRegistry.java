package net.prismaticvoid.voidfurniture;

import com.ibm.icu.impl.UResource;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {
    public static final ChairBlock OAK_CHAIR = registerWithItem("oak_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock BIRCH_CHAIR = registerWithItem("birch_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock SPRUCE_CHAIR = registerWithItem("spruce_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock JUNGLE_CHAIR = registerWithItem("jungle_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock DARK_OAK_CHAIR = registerWithItem("dark_oak_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final ChairBlock ACACIA_CHAIR = registerWithItem("acacia_chair",
            new ChairBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final Block OAK_TABLE_CENTER = registerWithItem("oak_table_center",
            new TableCenterBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static final TableCornerBlock OAK_TABLE_CORNER = registerWithItem ("oak_table_corner",
            new TableCornerBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f).nonOpaque())
    );

    public static void init() {

    }

    private static <B extends Block> B registerWithItem(String name, B block) {
        final B b = register(name, block);
        Registry.register(Registry.ITEM, Utils.id(name), new BlockItem(b, new FabricItemSettings().group(Utils.GROUP)));
        return b;
    }

    private static <B extends Block> B register(String name, B block) {
        return Registry.register(Registry.BLOCK, Utils.id(name), block);
    }
}

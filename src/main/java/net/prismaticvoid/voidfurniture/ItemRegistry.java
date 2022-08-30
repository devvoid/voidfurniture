package net.prismaticvoid.voidfurniture;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.Item;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.function.Function;

public class ItemRegistry {
    public static final HashMap<String, Item> ITEMS = new HashMap<>();

    public static void init() {
        register("gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("gold_candlestick"),
                BlockRegistry.get("gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("white_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("white_gold_candlestick"),
                BlockRegistry.get("white_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("orange_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("orange_gold_candlestick"),
                BlockRegistry.get("orange_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("magenta_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("magenta_gold_candlestick"),
                BlockRegistry.get("magenta_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("light_blue_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("light_blue_gold_candlestick"),
                BlockRegistry.get("light_blue_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("yellow_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("yellow_gold_candlestick"),
                BlockRegistry.get("yellow_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("lime_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("lime_gold_candlestick"),
                BlockRegistry.get("lime_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("pink_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("pink_gold_candlestick"),
                BlockRegistry.get("pink_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("gray_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("gray_gold_candlestick"),
                BlockRegistry.get("gray_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("light_gray_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("light_gray_gold_candlestick"),
                BlockRegistry.get("light_gray_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("cyan_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("cyan_gold_candlestick"),
                BlockRegistry.get("cyan_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("purple_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("purple_gold_candlestick"),
                BlockRegistry.get("purple_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("blue_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("blue_gold_candlestick"),
                BlockRegistry.get("blue_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("brown_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("brown_gold_candlestick"),
                BlockRegistry.get("brown_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("green_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("green_gold_candlestick"),
                BlockRegistry.get("green_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("red_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("red_gold_candlestick"),
                BlockRegistry.get("red_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("black_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("black_gold_candlestick"),
                BlockRegistry.get("black_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));

        register("iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("iron_candlestick"),
                BlockRegistry.get("iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("white_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("white_iron_candlestick"),
                BlockRegistry.get("white_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("orange_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("orange_iron_candlestick"),
                BlockRegistry.get("orange_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("magenta_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("magenta_iron_candlestick"),
                BlockRegistry.get("magenta_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("light_blue_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("light_blue_iron_candlestick"),
                BlockRegistry.get("light_blue_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("yellow_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("yellow_iron_candlestick"),
                BlockRegistry.get("yellow_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("lime_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("lime_iron_candlestick"),
                BlockRegistry.get("lime_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("pink_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("pink_iron_candlestick"),
                BlockRegistry.get("pink_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("gray_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("gray_iron_candlestick"),
                BlockRegistry.get("gray_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("light_gray_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("light_gray_iron_candlestick"),
                BlockRegistry.get("light_gray_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("cyan_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("cyan_iron_candlestick"),
                BlockRegistry.get("cyan_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("purple_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("purple_iron_candlestick"),
                BlockRegistry.get("purple_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("blue_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("blue_iron_candlestick"),
                BlockRegistry.get("blue_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("brown_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("brown_iron_candlestick"),
                BlockRegistry.get("brown_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("green_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("green_iron_candlestick"),
                BlockRegistry.get("green_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("red_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("red_iron_candlestick"),
                BlockRegistry.get("red_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("black_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("black_iron_candlestick"),
                BlockRegistry.get("black_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
    }

    private static <I extends Item> void register(String name, I item) {
        ITEMS.put(name, Registry.register(Registry.ITEM, Utils.id(name), item));
    }

    private static <I extends Item> void registerDyedBlock(String name, FabricItemSettings settings, Function<FabricItemSettings,I> factory) {
        String[] types = {"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};

        for (int i = 0; i < types.length; i++) {
            var new_name = name.replace("base", types[i]);

            register(new_name, factory.apply(settings));
        }
    }
}

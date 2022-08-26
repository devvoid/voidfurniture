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
        register("candlesticks/gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/gold_candlestick"),
                BlockRegistry.get("candlesticks/gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/white_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/white_gold_candlestick"),
                BlockRegistry.get("candlesticks/white_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/orange_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/orange_gold_candlestick"),
                BlockRegistry.get("candlesticks/orange_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/magenta_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/magenta_gold_candlestick"),
                BlockRegistry.get("candlesticks/magenta_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/light_blue_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/light_blue_gold_candlestick"),
                BlockRegistry.get("candlesticks/light_blue_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/yellow_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/yellow_gold_candlestick"),
                BlockRegistry.get("candlesticks/yellow_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/lime_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/lime_gold_candlestick"),
                BlockRegistry.get("candlesticks/lime_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/pink_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/pink_gold_candlestick"),
                BlockRegistry.get("candlesticks/pink_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/gray_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/gray_gold_candlestick"),
                BlockRegistry.get("candlesticks/gray_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/light_gray_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/light_gray_gold_candlestick"),
                BlockRegistry.get("candlesticks/light_gray_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/cyan_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/cyan_gold_candlestick"),
                BlockRegistry.get("candlesticks/cyan_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/purple_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/purple_gold_candlestick"),
                BlockRegistry.get("candlesticks/purple_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/blue_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/blue_gold_candlestick"),
                BlockRegistry.get("candlesticks/blue_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/brown_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/brown_gold_candlestick"),
                BlockRegistry.get("candlesticks/brown_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/green_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/green_gold_candlestick"),
                BlockRegistry.get("candlesticks/green_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/red_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/red_gold_candlestick"),
                BlockRegistry.get("candlesticks/red_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/black_gold_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/black_gold_candlestick"),
                BlockRegistry.get("candlesticks/black_gold_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));

        register("candlesticks/iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/iron_candlestick"),
                BlockRegistry.get("candlesticks/iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/white_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/white_iron_candlestick"),
                BlockRegistry.get("candlesticks/white_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/orange_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/orange_iron_candlestick"),
                BlockRegistry.get("candlesticks/orange_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/magenta_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/magenta_iron_candlestick"),
                BlockRegistry.get("candlesticks/magenta_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/light_blue_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/light_blue_iron_candlestick"),
                BlockRegistry.get("candlesticks/light_blue_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/yellow_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/yellow_iron_candlestick"),
                BlockRegistry.get("candlesticks/yellow_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/lime_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/lime_iron_candlestick"),
                BlockRegistry.get("candlesticks/lime_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/pink_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/pink_iron_candlestick"),
                BlockRegistry.get("candlesticks/pink_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/gray_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/gray_iron_candlestick"),
                BlockRegistry.get("candlesticks/gray_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/light_gray_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/light_gray_iron_candlestick"),
                BlockRegistry.get("candlesticks/light_gray_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/cyan_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/cyan_iron_candlestick"),
                BlockRegistry.get("candlesticks/cyan_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/purple_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/purple_iron_candlestick"),
                BlockRegistry.get("candlesticks/purple_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/blue_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/blue_iron_candlestick"),
                BlockRegistry.get("candlesticks/blue_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/brown_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/brown_iron_candlestick"),
                BlockRegistry.get("candlesticks/brown_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/green_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/green_iron_candlestick"),
                BlockRegistry.get("candlesticks/green_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/red_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/red_iron_candlestick"),
                BlockRegistry.get("candlesticks/red_iron_wall_candlestick"),
                new FabricItemSettings().group(Utils.GROUP)
        ));
        register("candlesticks/black_iron_candlestick", new WallStandingBlockItem(
                BlockRegistry.get("candlesticks/black_iron_candlestick"),
                BlockRegistry.get("candlesticks/black_iron_wall_candlestick"),
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

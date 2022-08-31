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
        registerCandlestick("gold_candlestick");
        registerCandlestick("white_gold_candlestick");
        registerCandlestick("orange_gold_candlestick");
        registerCandlestick("magenta_gold_candlestick");
        registerCandlestick("light_blue_gold_candlestick");
        registerCandlestick("yellow_gold_candlestick");
        registerCandlestick("lime_gold_candlestick");
        registerCandlestick("pink_gold_candlestick");
        registerCandlestick("gray_gold_candlestick");
        registerCandlestick("light_gray_gold_candlestick");
        registerCandlestick("cyan_gold_candlestick");
        registerCandlestick("purple_gold_candlestick");
        registerCandlestick("blue_gold_candlestick");
        registerCandlestick("brown_gold_candlestick");
        registerCandlestick("green_gold_candlestick");
        registerCandlestick("red_gold_candlestick");
        registerCandlestick("black_gold_candlestick");

        registerCandlestick("iron_candlestick");
        registerCandlestick("white_iron_candlestick");
        registerCandlestick("orange_iron_candlestick");
        registerCandlestick("magenta_iron_candlestick");
        registerCandlestick("light_blue_iron_candlestick");
        registerCandlestick("yellow_iron_candlestick");
        registerCandlestick("lime_iron_candlestick");
        registerCandlestick("pink_iron_candlestick");
        registerCandlestick("gray_iron_candlestick");
        registerCandlestick("light_gray_iron_candlestick");
        registerCandlestick("cyan_iron_candlestick");
        registerCandlestick("purple_iron_candlestick");
        registerCandlestick("blue_iron_candlestick");
        registerCandlestick("brown_iron_candlestick");
        registerCandlestick("green_iron_candlestick");
        registerCandlestick("red_iron_candlestick");
        registerCandlestick("black_iron_candlestick");
    }

    private static <I extends Item> void register(String name, I item) {
        ITEMS.put(name, Registry.register(Registry.ITEM, Utils.id(name), item));
    }

    private static void registerCandlestick(String name) {
        register(name, new WallStandingBlockItem(
                BlockRegistry.get(name),
                BlockRegistry.get(name.replace("candlestick", "wall_candlestick")),
                new FabricItemSettings().group(Utils.GROUP)
        ));
    }
}

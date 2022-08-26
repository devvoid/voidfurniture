package net.prismaticvoid.voidfurniture;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
    public static final Item CANDLESTICK = register("gold_candlestick", new WallStandingBlockItem(
            BlockRegistry.get("candlesticks/gold_candlestick"),
            BlockRegistry.get("candlesticks/wall_gold_candlestick"),
            new FabricItemSettings().group(Utils.GROUP)
    ));

    private static <I extends Item> I register(String name, I item) {
        return Registry.register(Registry.ITEM, Utils.id(name), item);
    }
}

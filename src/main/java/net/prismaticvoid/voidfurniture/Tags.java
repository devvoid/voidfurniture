package net.prismaticvoid.voidfurniture;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public final class Tags {
    public final static TagKey<Block> FAIRY_LIGHTS = registerBlock("fairy_lights");
    public final static TagKey<Block> BENCHES = registerBlock("benches");

    public final static TagKey<Item> SHOVELS = registerItem("shovels");

    private static TagKey<Block> registerBlock(String id) {
        return TagKey.of(Registry.BLOCK_KEY, Utils.id(id));
    }

    private static TagKey<Item> registerItem(String id) {
        return TagKey.of(Registry.ITEM_KEY, Utils.id(id));
    }
}

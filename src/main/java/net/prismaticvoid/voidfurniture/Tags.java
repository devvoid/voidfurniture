package net.prismaticvoid.voidfurniture;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public final class Tags {
    public final static TagKey<Block> FAIRY_LIGHTS = register("fairy_lights");

    private static TagKey<Block> register(String id) {
        return TagKey.of(Registry.BLOCK_KEY, Utils.id(id));
    }
}

package net.prismaticvoid.voidfurniture;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Utils {
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(
            new Identifier("voidfurniture", "general"),
            () -> new ItemStack(BlockRegistry.OAK_CHAIR)
    );

    public static Identifier id(String name) {
        return new Identifier("voidfurniture", name);
    }
}

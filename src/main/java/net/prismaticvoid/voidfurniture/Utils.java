package net.prismaticvoid.voidfurniture;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class Utils {
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(
            new Identifier("voidfurniture", "general"),
            () -> new ItemStack(BlockRegistry.BLOCKS.get("oak_chair"))
    );

    public static Identifier id(String name) {
        return new Identifier("voidfurniture", name);
    }

    public static VoxelShape make_cuboid(double x, double y, double z, double size_x, double size_y, double size_z) {
        var xpos = x / 16.0;
        var ypos = y / 16.0;
        var zpos = z / 16.0;

        var xpos2 = xpos + (size_x / 16.0);
        var ypos2 = ypos + (size_y / 16.0);
        var zpos2 = zpos + (size_z / 16.0);

        return VoxelShapes.cuboid(xpos, ypos, zpos, xpos2, ypos2, zpos2);
    }
}

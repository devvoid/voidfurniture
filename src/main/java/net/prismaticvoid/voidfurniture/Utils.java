package net.prismaticvoid.voidfurniture;

import it.unimi.dsi.fastutil.Hash;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.HashMap;

public class Utils {
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(
            Utils.id("general"),
            () -> new ItemStack(BlockRegistry.get("oak_chair"))
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

    public static HashMap<Direction, VoxelShape> createRotatedShapes(VoxelShape shape) {
        var v = new HashMap<Direction, VoxelShape>();

        v.put(Direction.NORTH, rotateShape(Direction.NORTH, shape));
        v.put(Direction.SOUTH, rotateShape(Direction.SOUTH, shape));
        v.put(Direction.EAST, rotateShape(Direction.EAST, shape));
        v.put(Direction.WEST, rotateShape(Direction.WEST, shape));

        return v;
    }

    public static VoxelShape rotateShape(Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{ shape, VoxelShapes.empty() };
        int times = (to.getHorizontal() - Direction.NORTH.getHorizontal() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.union(buffer[1], VoxelShapes.cuboid(1-maxZ, minY, minX, 1-minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }
}

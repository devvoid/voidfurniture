package net.prismaticvoid.voidfurniture.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.prismaticvoid.voidfurniture.Tags;
import net.prismaticvoid.voidfurniture.Utils;

import java.util.HashMap;

public class BenchBlock extends AbstractConnectingBlock {
    private static final HashMap<Direction, VoxelShape> SHAPES_LEFT;
    private static final HashMap<Direction, VoxelShape> SHAPES_BOTH;
    private static final HashMap<Direction, VoxelShape> SHAPES_RIGHT;
    private static final HashMap<Direction, VoxelShape> SHAPES_NONE;

    static {
        var vb1 = VoxelShapes.cuboid(0, 0, 0.0625, 0.0625, 0.625, 0.1875);
        var vb2 = VoxelShapes.cuboid(0.9375, 0, 0.0625, 1, 0.625, 0.1875);
        var vb3 = VoxelShapes.cuboid(0.9375, 0, 0.8125, 1, 0.625, 0.9375);
        var vb4 = VoxelShapes.cuboid(0, 0, 0.8125, 0.0625, 0.625, 0.9375);
        var vb5 = VoxelShapes.cuboid(0, 0.625, 0.0625, 1, 0.6875, 0.9375);
        var vb6 = VoxelShapes.cuboid(0, 0.6875, 0.875, 0.0625, 1.4375, 0.9375);
        var vb7 = VoxelShapes.cuboid(0.9375, 0.6875, 0.875, 1, 1.4375, 0.9375);
        var vb8 = VoxelShapes.cuboid(0.6875, 0.6875, 0.875, 0.8125, 1.4375, 0.9375);
        var vb9 = VoxelShapes.cuboid(0.4375, 0.6875, 0.875, 0.5625, 1.4375, 0.9375);
        var vb10 = VoxelShapes.cuboid(0.1875, 0.6875, 0.875, 0.3125, 1.4375, 0.9375);
        var vb11 = VoxelShapes.cuboid(0, 1.4375, 0.875, 1, 1.6875, 0.9375);
        var vb12 = VoxelShapes.cuboid(0.9375, 0.6875, 0.0625, 1, 0.9375, 0.1875);
        var vb13 = VoxelShapes.cuboid(0.9375, 0.9375, 0.0625, 1, 1, 0.875);
        var vb14 = VoxelShapes.cuboid(0, 0.6875, 0.0625, 0.0625, 0.9375, 0.1875);
        var vb15 = VoxelShapes.cuboid(0, 0.9375, 0.0625, 0.0625, 1, 0.875);

        SHAPES_BOTH = Utils.createRotatedShapes(VoxelShapes.union(vb1, vb2, vb3, vb4, vb5, vb6, vb7, vb8, vb9, vb10, vb11, vb12, vb13, vb14, vb15));

        var vl1 = VoxelShapes.cuboid(0.9375, 0, 0.0625, 1, 0.625, 0.1875);
        var vl2 = VoxelShapes.cuboid(0.9375, 0, 0.8125, 1, 0.625, 0.9375);
        var vl3 = VoxelShapes.cuboid(0, 0.625, 0.0625, 1, 0.6875, 0.9375);
        var vl4 = VoxelShapes.cuboid(0, 0.6875, 0.875, 0.0625, 1.4375, 0.9375);
        var vl5 = VoxelShapes.cuboid(0.9375, 0.6875, 0.875, 1, 1.4375, 0.9375);
        var vl6 = VoxelShapes.cuboid(0.6875, 0.6875, 0.875, 0.8125, 1.4375, 0.9375);
        var vl7 = VoxelShapes.cuboid(0.4375, 0.6875, 0.875, 0.5625, 1.4375, 0.9375);
        var vl8 = VoxelShapes.cuboid(0.1875, 0.6875, 0.875, 0.3125, 1.4375, 0.9375);
        var vl9 = VoxelShapes.cuboid(0, 1.4375, 0.875, 1, 1.6875, 0.9375);
        var vl10 = VoxelShapes.cuboid(0.9375, 0.6875, 0.0625, 1, 0.9375, 0.1875);
        var vl11 = VoxelShapes.cuboid(0.9375, 0.9375, 0.0625, 1, 1, 0.875);

        SHAPES_LEFT = Utils.createRotatedShapes(VoxelShapes.union(vl1, vl2, vl3, vl4, vl5, vl6, vl7, vl8, vl9, vl10, vl11));

        var vr1 = VoxelShapes.cuboid(0, 0, 0.0625, 0.0625, 0.625, 0.1875);
        var vr2 = VoxelShapes.cuboid(0, 0, 0.8125, 0.0625, 0.625, 0.9375);
        var vr3 = VoxelShapes.cuboid(0, 0.625, 0.0625, 1, 0.6875, 0.9375);
        var vr4 = VoxelShapes.cuboid(0, 0.6875, 0.875, 0.0625, 1.4375, 0.9375);
        var vr5 = VoxelShapes.cuboid(0.9375, 0.6875, 0.875, 1, 1.4375, 0.9375);
        var vr6 = VoxelShapes.cuboid(0.6875, 0.6875, 0.875, 0.8125, 1.4375, 0.9375);
        var vr7 = VoxelShapes.cuboid(0.4375, 0.6875, 0.875, 0.5625, 1.4375, 0.9375);
        var vr8 = VoxelShapes.cuboid(0.1875, 0.6875, 0.875, 0.3125, 1.4375, 0.9375);
        var vr9 = VoxelShapes.cuboid(0, 1.4375, 0.875, 1, 1.6875, 0.9375);
        var vr10 = VoxelShapes.cuboid(0, 0.6875, 0.0625, 0.0625, 0.9375, 0.1875);
        var vr11 = VoxelShapes.cuboid(0, 0.9375, 0.0625, 0.0625, 1, 0.875);

        SHAPES_RIGHT = Utils.createRotatedShapes(VoxelShapes.union(vr1,vr2,vr3,vr4,vr5,vr6,vr7,vr8,vr9,vr10,vr11));

        var vn1 = VoxelShapes.cuboid(0, 0.625, 0.0625, 1, 0.6875, 0.9375);
        var vn2 = VoxelShapes.cuboid(0, 0.6875, 0.875, 0.0625, 1.4375, 0.9375);
        var vn3 = VoxelShapes.cuboid(0.9375, 0.6875, 0.875, 1, 1.4375, 0.9375);
        var vn4 = VoxelShapes.cuboid(0.6875, 0.6875, 0.875, 0.8125, 1.4375, 0.9375);
        var vn5 = VoxelShapes.cuboid(0.4375, 0.6875, 0.875, 0.5625, 1.4375, 0.9375);
        var vn6 = VoxelShapes.cuboid(0.1875, 0.6875, 0.875, 0.3125, 1.4375, 0.937);
        var vn7 = VoxelShapes.cuboid(0, 1.4375, 0.875, 1, 1.6875, 0.9375);

        SHAPES_NONE = Utils.createRotatedShapes(VoxelShapes.union(vn1, vn2, vn3, vn4, vn5, vn6, vn7));
    }

    public BenchBlock(Settings settings) {
        super(settings, Tags.BENCHES);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);

        return switch(state.get(SIDES)) {
            case BOTH -> SHAPES_BOTH.get(dir);
            case LEFT -> SHAPES_LEFT.get(dir);
            case RIGHT -> SHAPES_RIGHT.get(dir);
            case NONE -> SHAPES_NONE.get(dir);
        };
    }
}

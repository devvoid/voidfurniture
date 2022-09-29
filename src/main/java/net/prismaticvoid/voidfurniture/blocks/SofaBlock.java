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

public class SofaBlock extends AbstractConnectingBlock {
    private static final HashMap<Direction, VoxelShape> SHAPES_LEFT = new HashMap<>();
    private static final HashMap<Direction, VoxelShape> SHAPES_BOTH = new HashMap<>();
    private static final HashMap<Direction, VoxelShape> SHAPES_RIGHT = new HashMap<>();
    private static final HashMap<Direction, VoxelShape> SHAPES_NONE = new HashMap<>();

    static {
        var vb1 = VoxelShapes.cuboid(0.0625, 0.25, 0.0625, 0.9375, 0.5, 0.75);
        var vb2 = VoxelShapes.cuboid(0.0625, 0.25, 0.75, 0.9375, 1.125, 1);
        var vb3 = VoxelShapes.cuboid(0, 0, 0.125, 0.0625, 0.8125, 0.9375);
        var vb4 = VoxelShapes.cuboid(0.9375, 0, 0.125, 1, 0.8125, 0.9375);

        VoxelShape shapeBoth = VoxelShapes.union(vb1, vb2, vb3, vb4);

        SHAPES_BOTH.put(Direction.NORTH, Utils.rotateShape(Direction.NORTH, shapeBoth));
        SHAPES_BOTH.put(Direction.SOUTH, Utils.rotateShape(Direction.SOUTH, shapeBoth));
        SHAPES_BOTH.put(Direction.EAST, Utils.rotateShape(Direction.EAST, shapeBoth));
        SHAPES_BOTH.put(Direction.WEST, Utils.rotateShape(Direction.WEST, shapeBoth));

        var vl1 = VoxelShapes.cuboid(0, 0.25, 0.0625, 0.9375, 0.5, 0.75);
        var vl2 = VoxelShapes.cuboid(0, 0.25, 0.75, 0.9375, 1.125, 1);
        var vl3 = VoxelShapes.cuboid(0.9375, 0, 0.125, 1, 0.8125, 0.9375);

        VoxelShape shapeLeft = VoxelShapes.union(vl1, vl2, vl3);

        SHAPES_LEFT.put(Direction.NORTH, Utils.rotateShape(Direction.NORTH, shapeLeft));
        SHAPES_LEFT.put(Direction.SOUTH, Utils.rotateShape(Direction.SOUTH, shapeLeft));
        SHAPES_LEFT.put(Direction.EAST, Utils.rotateShape(Direction.EAST, shapeLeft));
        SHAPES_LEFT.put(Direction.WEST, Utils.rotateShape(Direction.WEST, shapeLeft));

        var vr1 = VoxelShapes.cuboid(0.0625, 0.25, 0.0625, 1, 0.5, 0.75);
        var vr2 = VoxelShapes.cuboid(0.0625, 0.25, 0.75, 1, 1.125, 1);
        var vr3 = VoxelShapes.cuboid(0, 0, 0.125, 0.0625, 0.8125, 0.9375);

        VoxelShape shapeRight = VoxelShapes.union(vr1,vr2,vr3);

        SHAPES_RIGHT.put(Direction.NORTH, Utils.rotateShape(Direction.NORTH, shapeRight));
        SHAPES_RIGHT.put(Direction.SOUTH, Utils.rotateShape(Direction.SOUTH, shapeRight));
        SHAPES_RIGHT.put(Direction.EAST, Utils.rotateShape(Direction.EAST, shapeRight));
        SHAPES_RIGHT.put(Direction.WEST, Utils.rotateShape(Direction.WEST, shapeRight));

        var vn1 = VoxelShapes.cuboid(0, 0.25, 0.0625, 1, 0.5, 0.75);
        var vn2 = VoxelShapes.cuboid(0, 0.25, 0.75, 1, 1.125, 1);

        VoxelShape shapeNone = VoxelShapes.union(vn1, vn2);

        SHAPES_NONE.put(Direction.NORTH, Utils.rotateShape(Direction.NORTH, shapeNone));
        SHAPES_NONE.put(Direction.SOUTH, Utils.rotateShape(Direction.SOUTH, shapeNone));
        SHAPES_NONE.put(Direction.EAST, Utils.rotateShape(Direction.EAST, shapeNone));
        SHAPES_NONE.put(Direction.WEST, Utils.rotateShape(Direction.WEST, shapeNone));
    }

    public SofaBlock(Settings settings) {
        super(settings, Tags.SOFAS);
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

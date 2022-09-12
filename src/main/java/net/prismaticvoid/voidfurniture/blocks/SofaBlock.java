package net.prismaticvoid.voidfurniture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.prismaticvoid.voidfurniture.Tags;
import net.prismaticvoid.voidfurniture.Utils;

import java.util.HashMap;

public class SofaBlock extends HorizontalFacingBlock {
    private static final BooleanProperty LEFT = BooleanProperty.of("left");
    private static final BooleanProperty RIGHT = BooleanProperty.of("right");

    private static final HashMap<Direction, Direction> LEFT_DIRECTIONS;
    private static final HashMap<Direction, Direction> RIGHT_DIRECTIONS;

    private static final HashMap<Direction, VoxelShape> SHAPES_LEFT = new HashMap<>();
    private static final HashMap<Direction, VoxelShape> SHAPES_BOTH = new HashMap<>();
    private static final HashMap<Direction, VoxelShape> SHAPES_RIGHT = new HashMap<>();
    private static final HashMap<Direction, VoxelShape> SHAPES_NONE = new HashMap<>();

    static {
        LEFT_DIRECTIONS = new HashMap<>();
        LEFT_DIRECTIONS.put(Direction.NORTH, Direction.WEST);
        LEFT_DIRECTIONS.put(Direction.EAST, Direction.NORTH);
        LEFT_DIRECTIONS.put(Direction.SOUTH, Direction.EAST);
        LEFT_DIRECTIONS.put(Direction.WEST, Direction.SOUTH);

        RIGHT_DIRECTIONS = new HashMap<>();
        RIGHT_DIRECTIONS.put(Direction.NORTH, Direction.EAST);
        RIGHT_DIRECTIONS.put(Direction.EAST, Direction.SOUTH);
        RIGHT_DIRECTIONS.put(Direction.SOUTH, Direction.WEST);
        RIGHT_DIRECTIONS.put(Direction.WEST, Direction.NORTH);

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
        super(settings);
        setDefaultState(
                this.stateManager.getDefaultState()
                        .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                        .with(LEFT, false)
                        .with(RIGHT, false)
        );
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        var world = ctx.getWorld();
        var pos = ctx.getBlockPos();
        var facing = ctx.getPlayerFacing().getOpposite();

        var left = LEFT_DIRECTIONS.get(facing);
        var right = RIGHT_DIRECTIONS.get(facing);

        var block_left = pos.offset(left);
        var block_right = pos.offset(right);

        return this.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite())
                .with(LEFT, canConnect(world.getBlockState(block_left)))
                .with(RIGHT, canConnect(world.getBlockState(block_right)));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        var facing = state.get(Properties.HORIZONTAL_FACING);

        var block_left = pos.offset(LEFT_DIRECTIONS.get(facing));
        var block_right = pos.offset(RIGHT_DIRECTIONS.get(facing));

        return state
                // Yes, this is inverted. No, I don't know why. There must be
                // another inversion somewhere else that I can't find right now.
                .with(RIGHT, canConnect(world.getBlockState(block_left)))
                .with(LEFT, canConnect(world.getBlockState(block_right)));
    }

    protected Boolean canConnect(BlockState state) {
        return state.isIn(Tags.SOFAS);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING, LEFT, RIGHT);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);

        if (state.get(LEFT) && state.get(RIGHT)) {
            return SHAPES_NONE.get(dir);
        }
        else if (state.get(LEFT)) {
            return SHAPES_RIGHT.get(dir);
        }
        else if (state.get(RIGHT)) {
            return SHAPES_LEFT.get(dir);
        }
        else {
            return SHAPES_BOTH.get(dir);
        }
    }
}

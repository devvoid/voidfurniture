package net.prismaticvoid.voidfurniture;

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

import java.util.HashMap;

public class BenchBlock extends HorizontalFacingBlock {
    private static final BooleanProperty LEFT = BooleanProperty.of("left");
    private static final BooleanProperty RIGHT = BooleanProperty.of("right");

    private static final HashMap<Direction, Direction> LEFT_DIRECTIONS;
    private static final HashMap<Direction, Direction> RIGHT_DIRECTIONS;

    private static final HashMap<Direction, VoxelShape> SHAPES;

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

        SHAPES = new HashMap<>();

        var s1 = VoxelShapes.cuboid(0, 0, 0.0625, 0.0625, 0.625, 0.1875);
        var s2 = VoxelShapes.cuboid(0.9375, 0, 0.0625, 1, 0.625, 0.1875);
        var s3 = VoxelShapes.cuboid(0.9375, 0, 0.8125, 1, 0.625, 0.9375);
        var s4 = VoxelShapes.cuboid(0, 0, 0.8125, 0.0625, 0.625, 0.9375);
        var s5 = VoxelShapes.cuboid(0, 0.625, 0.0625, 1, 0.6875, 0.9375);
        var s6 = VoxelShapes.cuboid(0, 0.6875, 0.875, 0.0625, 1.4375, 0.9375);
        var s7 = VoxelShapes.cuboid(0.9375, 0.6875, 0.875, 1, 1.4375, 0.9375);
        var s8 = VoxelShapes.cuboid(0.6875, 0.6875, 0.875, 0.8125, 1.4375, 0.9375);
        var s9 = VoxelShapes.cuboid(0.4375, 0.6875, 0.875, 0.5625, 1.4375, 0.9375);
        var s10 = VoxelShapes.cuboid(0.1875, 0.6875, 0.875, 0.3125, 1.4375, 0.9375);
        var s11 = VoxelShapes.cuboid(0, 1.4375, 0.875, 1, 1.6875, 0.9375);

        VoxelShape shape = VoxelShapes.union(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11);

        SHAPES.put(Direction.NORTH, Utils.rotateShape(Direction.NORTH, shape));
        SHAPES.put(Direction.SOUTH, Utils.rotateShape(Direction.SOUTH, shape));
        SHAPES.put(Direction.EAST, Utils.rotateShape(Direction.EAST, shape));
        SHAPES.put(Direction.WEST, Utils.rotateShape(Direction.WEST, shape));
    }

    public BenchBlock(Settings settings) {
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
        return state.isIn(Tags.BENCHES);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING, LEFT, RIGHT);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);

        return SHAPES.get(dir);
    }
}

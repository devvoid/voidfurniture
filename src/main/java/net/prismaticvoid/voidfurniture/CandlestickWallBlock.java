package net.prismaticvoid.voidfurniture;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class CandlestickWallBlock extends CandlestickBlock {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public static final HashMap<Direction, VoxelShape> SHAPES;

    static {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.3125, 0.5625, 0.5625, 0.8125, 0.6875));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.25, 0.5, 0.625, 0.5625, 0.75));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.25, 0.9375, 0.625, 0.5625, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.46875, 0.3125, 0.75, 0.53125, 0.5, 0.9375));

        SHAPES = Utils.createRotatedShapes(shape);
    }

    public CandlestickWallBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        var facing = state.get(FACING);

        switch (facing) {
            case NORTH -> {
                return ImmutableList.of(new Vec3d(0.5, 14.5 / 16, 10.0/16.0 ));
            }
            case SOUTH -> {
                return ImmutableList.of(new Vec3d(0.5, 14.5 / 16, 6.0/16.0 ));
            }
            case EAST -> {
                return ImmutableList.of(new Vec3d(6.0/16.0, 14.5 / 16, 0.5 ));
            }
            case WEST -> {
                return ImmutableList.of(new Vec3d(10.0/16.0, 14.5 / 16, 0.5 ));
            }
            default -> {
                return PARTICLE_OFFSETS;
            }
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isSideSolidFullSquare(world, blockPos, direction);
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction[] directions;
        BlockState blockState = this.getDefaultState();
        World worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        for (Direction direction : directions = ctx.getPlacementDirections()) {
            Direction direction2;
            if (!direction.getAxis().isHorizontal() || !(blockState = blockState.with(FACING, direction2 = direction.getOpposite())).canPlaceAt(worldView, blockPos))
                continue;
            return blockState;
        }
        return null;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return state;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        var dir = state.get(Properties.HORIZONTAL_FACING);

        return SHAPES.get(dir);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CandlestickBlock.LIT);
        builder.add(FACING);
    }
}

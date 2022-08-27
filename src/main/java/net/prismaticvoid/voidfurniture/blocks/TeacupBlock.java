package net.prismaticvoid.voidfurniture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.prismaticvoid.voidfurniture.Utils;

import java.util.HashMap;

public class TeacupBlock extends Block {
    private static final HashMap<Direction, VoxelShape> SHAPES;

    static {
        var s1 = VoxelShapes.cuboid(0.625, 0, 0.46875, 0.75, 0.25, 0.53125);
        var s2 = VoxelShapes.cuboid(0.375, 0, 0.375, 0.625, 0.25, 0.625);

        SHAPES = Utils.createRotatedShapes(VoxelShapes.union(s1, s2));
    }

    public TeacupBlock(Settings settings) {
        super(settings);
        setDefaultState(
                getStateManager().getDefaultState()
                        .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        var dir = state.get(Properties.HORIZONTAL_FACING);
        return SHAPES.get(dir);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN && !this.canPlaceAt(state, world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }
}

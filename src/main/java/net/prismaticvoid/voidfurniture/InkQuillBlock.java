package net.prismaticvoid.voidfurniture;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.Dictionary;
import java.util.HashMap;

public class InkQuillBlock extends HorizontalFacingBlock {
    public static final HashMap<Direction, VoxelShape> SHAPES = new HashMap<>();

    static {
        VoxelShape shape = VoxelShapes.empty();

        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0, 0.375, 0.625, 0.25, 0.625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.25, 0.4375, 0.5625, 0.3125, 0.5625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.1875, 0.5, 0.5625, 0.5625, 0.5));

        SHAPES.put(Direction.NORTH, Utils.rotateShape(Direction.NORTH, shape));
        SHAPES.put(Direction.SOUTH, Utils.rotateShape(Direction.SOUTH, shape));
        SHAPES.put(Direction.WEST, Utils.rotateShape(Direction.WEST, shape));
        SHAPES.put(Direction.EAST, Utils.rotateShape(Direction.EAST, shape));
    }

    protected InkQuillBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        var dir = state.get(Properties.HORIZONTAL_FACING);

        return SHAPES.get(dir);
    }
}

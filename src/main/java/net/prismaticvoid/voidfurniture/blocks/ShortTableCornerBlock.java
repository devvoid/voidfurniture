package net.prismaticvoid.voidfurniture.blocks;

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
import net.prismaticvoid.voidfurniture.Utils;

public class ShortTableCornerBlock extends HorizontalFacingBlock {
    public ShortTableCornerBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        var top = Utils.make_cuboid(0.0, 10.0, 0.0, 16, 2, 16);

        Direction dir = state.get(FACING);

        var leg = switch(dir) {
            case NORTH -> Utils.make_cuboid(12.0, 0.0, 12.0, 3.0, 10.0, 3.0);
            case SOUTH -> Utils.make_cuboid(1.0, 0.0, 1.0, 3.0, 10.0, 3.0);
            case EAST -> Utils.make_cuboid(1.0, 0.0, 12.0, 3.0, 10.0, 3.0);
            case WEST -> Utils.make_cuboid(12.0, 0.0, 1.0, 3.0, 10.0, 3.0);
            default -> VoxelShapes.fullCube();
        };

        return VoxelShapes.union(top, leg);
    }
}

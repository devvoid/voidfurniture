package net.prismaticvoid.voidfurniture;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ChairBlock extends Block {
    public static final BooleanProperty SCOOTED = BooleanProperty.of("scooted");

    public ChairBlock(Settings settings) {
        super(settings);
        setDefaultState(
                getStateManager().getDefaultState()
                        .with(SCOOTED, false)
                        .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SCOOTED);
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        var dir = state.get(Properties.HORIZONTAL_FACING);

        if (state.get(SCOOTED)) {
            switch (dir) {
                case NORTH:
                    return Utils.make_cuboid(1, 0, -7, 14, 11, 14);
                case SOUTH:
                    return Utils.make_cuboid(1, 0, 9, 14, 11, 14);
                case EAST:
                    return Utils.make_cuboid(9, 0, 1, 14, 11, 14);
                case WEST:
                    return Utils.make_cuboid(-7, 0, 1, 14, 11, 14);
                default:
                    return VoxelShapes.fullCube();
            }

        }
        else {
            return Utils.make_cuboid(1, 0, 1, 14, 11, 14);
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        boolean current = world.getBlockState(pos).get(SCOOTED);

        world.setBlockState(pos, state.with(SCOOTED, !current));

        return ActionResult.SUCCESS;
    }
}

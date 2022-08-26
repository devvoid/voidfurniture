package net.prismaticvoid.voidfurniture.blocks;

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
import net.prismaticvoid.voidfurniture.Utils;

import java.util.HashMap;

public class ChairBlock extends Block {
    public static final BooleanProperty SCOOTED = BooleanProperty.of("scooted");

    private static final HashMap<Direction, VoxelShape> SHAPES = new HashMap<>();
    private static final HashMap<Direction, VoxelShape> SHAPES_SCOOTED = new HashMap<>();

    static {
        VoxelShape chair = VoxelShapes.empty();
        chair = VoxelShapes.union(chair, VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.125, 0.625, 0.125));
        chair = VoxelShapes.union(chair, VoxelShapes.cuboid(0.875, 0, 0.875, 0.9375, 0.625, 0.9375));
        chair = VoxelShapes.union(chair, VoxelShapes.cuboid(0.0625, 0, 0.875, 0.125, 0.625, 0.9375));
        chair = VoxelShapes.union(chair, VoxelShapes.cuboid(0.875, 0, 0.0625, 0.9375, 0.625, 0.125));
        chair = VoxelShapes.union(chair, VoxelShapes.cuboid(0.0625, 0.625, 0.0625, 0.9375, 0.6875, 0.9375));
        chair = VoxelShapes.union(chair, VoxelShapes.cuboid(0.0625, 0.6875, 0.875, 0.9375, 1.5625, 0.9375));

        SHAPES.put(Direction.NORTH, Utils.rotateShape(Direction.NORTH, chair));
        SHAPES.put(Direction.SOUTH, Utils.rotateShape(Direction.SOUTH, chair));
        SHAPES.put(Direction.WEST, Utils.rotateShape(Direction.WEST, chair));
        SHAPES.put(Direction.EAST, Utils.rotateShape(Direction.EAST, chair));

        VoxelShape chairScooted = VoxelShapes.empty();
        chairScooted = VoxelShapes.union(chairScooted, VoxelShapes.cuboid(0.0625, 0, -0.4375, 0.125, 0.625, -0.375));
        chairScooted = VoxelShapes.union(chairScooted, VoxelShapes.cuboid(0.875, 0, 0.375, 0.9375, 0.625, 0.4375));
        chairScooted = VoxelShapes.union(chairScooted, VoxelShapes.cuboid(0.0625, 0, 0.375, 0.125, 0.625, 0.4375));
        chairScooted = VoxelShapes.union(chairScooted, VoxelShapes.cuboid(0.875, 0, -0.4375, 0.9375, 0.625, -0.375));
        chairScooted = VoxelShapes.union(chairScooted, VoxelShapes.cuboid(0.0625, 0.625, -0.4375, 0.9375, 0.6875, 0.4375));
        chairScooted = VoxelShapes.union(chairScooted, VoxelShapes.cuboid(0.0625, 0.6875, 0.375, 0.9375, 1.5625, 0.4375));

        SHAPES_SCOOTED.put(Direction.NORTH, Utils.rotateShape(Direction.NORTH, chairScooted));
        SHAPES_SCOOTED.put(Direction.SOUTH, Utils.rotateShape(Direction.SOUTH, chairScooted));
        SHAPES_SCOOTED.put(Direction.WEST, Utils.rotateShape(Direction.WEST, chairScooted));
        SHAPES_SCOOTED.put(Direction.EAST, Utils.rotateShape(Direction.EAST, chairScooted));
    }

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
            return SHAPES_SCOOTED.get(dir);
        }
        else {
            return SHAPES.get(dir);
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.isInSneakingPose()) {
            boolean current = world.getBlockState(pos).get(SCOOTED);

            world.setBlockState(pos, state.with(SCOOTED, !current));
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}

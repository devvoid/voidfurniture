package net.prismaticvoid.voidfurniture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
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

public class BookStackBlock extends HorizontalFacingBlock {
    public static final BooleanProperty TIDY = BooleanProperty.of("tidy");
    public static final IntProperty BOOKS = IntProperty.of("books", 1, 3);

    // We only need one shape for one book since it's the same either way
    private static final HashMap<Direction, VoxelShape> SHAPE_ONEBOOK;
    private static final HashMap<Direction, VoxelShape> SHAPE_TWOBOOKS;
    private static final HashMap<Direction, VoxelShape> SHAPE_TWOBOOKS_TIDY;
    private static final HashMap<Direction, VoxelShape> SHAPE_THREEBOOKS;
    private static final HashMap<Direction, VoxelShape> SHAPE_THREEBOOKS_TIDY;

    static {
        var s1 = VoxelShapes.cuboid(0.3125, 0, 0.25, 0.6875, 0.125, 0.75);
        var s2 =VoxelShapes.cuboid(0.375, 0.125, 0.3125, 0.75, 0.25, 0.8125);
        var s3 = VoxelShapes.cuboid(0.3125, 0.25, 0.1875, 0.6875, 0.375, 0.6875);

        SHAPE_ONEBOOK = Utils.createRotatedShapes(s1);
        SHAPE_TWOBOOKS = Utils.createRotatedShapes(VoxelShapes.union(s1, s2));
        SHAPE_THREEBOOKS = Utils.createRotatedShapes(VoxelShapes.union(s1, s2, s3));

        SHAPE_TWOBOOKS_TIDY = Utils.createRotatedShapes(VoxelShapes.cuboid(0.3125, 0, 0.25, 0.6875, 0.25, 0.75));
        SHAPE_THREEBOOKS_TIDY = Utils.createRotatedShapes(VoxelShapes.cuboid(0.3125, 0, 0.25, 0.6875, 0.375, 0.75));
    }

    public BookStackBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(BOOKS, 1)
                .with(TIDY, true)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(BOOKS);
        stateManager.add(TIDY);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        var tidy = state.get(TIDY);
        var num = state.get(BOOKS);
        var dir = state.get(Properties.HORIZONTAL_FACING);

        switch (num) {
            case 1:
                return SHAPE_ONEBOOK.get(dir);
            case 2:
                if (tidy) {
                    return SHAPE_TWOBOOKS_TIDY.get(dir);
                }
                else {
                    return SHAPE_TWOBOOKS.get(dir);
                }
            case 3:
                if (tidy) {
                    return SHAPE_THREEBOOKS_TIDY.get(dir);
                }
                else {
                    return SHAPE_THREEBOOKS.get(dir);
                }
        }

        return Utils.make_cuboid(4, 0, 4, 6,  2 * state.get(BOOKS), 6);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.isInSneakingPose()) {
            var tidy = world.getBlockState(pos).get(TIDY);
            world.setBlockState(pos, state.with(TIDY, !tidy));
            return ActionResult.SUCCESS;
        }

        var current = world.getBlockState(pos).get(BOOKS);
        current += 1;
        if (current >= 4) {
            current = 1;
        }

        world.setBlockState(pos, state.with(BOOKS, current));

        return ActionResult.SUCCESS;
    }
}

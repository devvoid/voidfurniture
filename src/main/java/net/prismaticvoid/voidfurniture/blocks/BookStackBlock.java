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

public class BookStackBlock extends HorizontalFacingBlock {
    public static final BooleanProperty TIDY = BooleanProperty.of("tidy");
    public static final IntProperty BOOKS = IntProperty.of("books", 1, 3);

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
        /*
        // This is correct for when it's facing north. I can't be bothered to
        // jury-rig a system to handle all 12 possible combinations right now...
        var book1 = Utils.make_cuboid(5, 0, 4, 6, 2, 8);
        var book2 = Utils.make_cuboid(6, 2, 5, 6, 2, 8);
        var book3 = Utils.make_cuboid(5, 4, 3, 6, 2, 8);
        */

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

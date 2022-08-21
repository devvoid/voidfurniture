package net.prismaticvoid.voidfurniture;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.AbstractCandleBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CandlestickBlock extends AbstractCandleBlock {
    public static final BooleanProperty LIT = AbstractCandleBlock.LIT;

    protected static final Iterable<Vec3d> PARTICLE_OFFSETS = ImmutableList.of(new Vec3d(0.5D, 14.0 / 16.0, 0.5D));

    protected static final VoxelShape SHAPE = Utils.make_cuboid(6, 0, 6, 4, 14, 4);

    public CandlestickBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState()
                .with(LIT, false)
        );
    }

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return PARTICLE_OFFSETS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!state.get(LIT)) {
            // Attempt to light
            if (itemStack.isOf(Items.FLINT_AND_STEEL) || itemStack.isOf(Items.FIRE_CHARGE)) {
                world.setBlockState(pos, state.with(LIT, true));
                return ActionResult.SUCCESS;
            }
        }
        else {
            // Not lit, so extinguish if hand empty.
            if (player.getStackInHand(hand).isEmpty()) {
                extinguish(player, state, world, pos);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(LIT);
    }
}

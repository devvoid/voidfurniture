package net.prismaticvoid.voidfurniture.blocks;

import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import net.prismaticvoid.voidfurniture.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ModdedCampfireBlock extends Block {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);

    public static final BooleanProperty LIT = Properties.LIT;
    public static final BooleanProperty SIGNAL_FIRE = Properties.SIGNAL_FIRE;

    // These can't be marked as final, because apparently setting them in the constructor means they "might not be initialized"...
    private boolean emitsParticles;
    private int fireDamage;

    public ModdedCampfireBlock(boolean emitsParticles, int fireDamage, AbstractBlock.Settings settings) {
        super(settings);

        this.emitsParticles = emitsParticles;
        this.fireDamage = fireDamage;

        setDefaultState(getStateManager().getDefaultState()
                .with(LIT, true)
                .with(SIGNAL_FIRE, false));
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (!state.get(LIT)) {
            // Attempt to light if not lit
            if (itemStack.isOf(Items.FLINT_AND_STEEL)) {
                var pitch = world.getRandom().nextFloat() * 0.4F + 0.8F;
                world.playSound(null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, pitch);
                world.setBlockState(pos, state.with(LIT, true));
                return ActionResult.SUCCESS;
            }

            if (itemStack.isOf(Items.FIRE_CHARGE)) {
                var random = world.getRandom();
                var pitch = (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F;
                world.playSound(null, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0F, pitch);
                world.setBlockState(pos, state.with(LIT, true));
                return ActionResult.SUCCESS;
            }
        }
        else {
            // Extinguish if the player is holding a shovel
            if (itemStack.isIn(Tags.SHOVELS)) {
                extinguish(player, world, pos, state);
                return ActionResult.SUCCESS;
            }

        }

        return ActionResult.PASS;
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (state.get(LIT)) {
            var immune = entity.isFireImmune();
            var isLiving = entity instanceof LivingEntity;
            var hasFrostWalker = EnchantmentHelper.hasFrostWalker((LivingEntity)entity);
            if (isLiving && !immune && !hasFrostWalker) {
                entity.damage(DamageSource.IN_FIRE, (float)this.fireDamage);
            }
        }

        super.onEntityCollision(state, world, pos, entity);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
    @Nullable
        var world = ctx.getWorld();
        var down = ctx.getBlockPos().down();

        var state = world.getBlockState(down);

        return this.getDefaultState().with(SIGNAL_FIRE, state.isOf(Blocks.HAY_BLOCK));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN ? state.with(SIGNAL_FIRE, neighborState.isOf(Blocks.HAY_BLOCK)) : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!state.get(LIT)) {
            return;
        }

        // Audio
        if (random.nextInt(10) == 0) {
            var x = (double)pos.getX() + 0.5D;
            var y = (double)pos.getY() + 0.5D;
            var z = (double)pos.getZ() + 0.5D;

            var vol = 0.5F + random.nextFloat();
            var pitch = random.nextFloat() * 0.7F + 0.6F;
            world.playSound(x, y, z, SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, vol, pitch, false);
        }

        // Smoke particles
        for(var i = 0; i < random.nextInt(2) + 2; ++i) {
            spawnSmokeParticle(world, pos, state.get(CampfireBlock.SIGNAL_FIRE), false);
        }

        // Embers/crackles
        if (!this.emitsParticles) {
            return;
        }

        if (random.nextInt(5) == 0) {
            for(int i = 0; i < random.nextInt(1) + 1; ++i) {
                var x = (double)pos.getX() + 0.5D;
                var y = (double)pos.getY() + 0.5D;
                var z = (double)pos.getZ() + 0.5D;

                var vel_x = random.nextFloat() / 2.0F;
                var vel_y = 5.0E-5D;
                var vel_z = random.nextFloat() / 2.0F;
                world.addParticle(ParticleTypes.LAVA, x, y, z, vel_x, vel_y, vel_z);
            }
        }
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, SIGNAL_FIRE);
    }

    public static void extinguish(@Nullable Entity entity, WorldAccess world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            for(int i = 0; i < 20; ++i) {
                spawnSmokeParticle((World)world, pos, state.get(SIGNAL_FIRE), true);
            }
        }

        world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);

        world.emitGameEvent(entity, GameEvent.BLOCK_CHANGE, pos);
        world.setBlockState(pos, state.with(LIT, false), 3);
    }

    public static void spawnSmokeParticle(World world, BlockPos pos, boolean isSignal, boolean lotsOfSmoke) {
        Random random = world.getRandom();
        DefaultParticleType partType = isSignal ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE : ParticleTypes.CAMPFIRE_COSY_SMOKE;

        var x = (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1);
        var y = (double)pos.getY() + random.nextDouble() + random.nextDouble();
        var z = (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1);

        world.addImportantParticle(partType, true, x, y, z, 0.0D, 0.07D, 0.0D);
        if (lotsOfSmoke) {
            var x2 = (double)pos.getX() + 0.5D + random.nextDouble() / 4.0D * (double)(random.nextBoolean() ? 1 : -1);
            var y2 = (double)pos.getY() + 0.4D;
            var z2 = (double)pos.getZ() + 0.5D + random.nextDouble() / 4.0D * (double)(random.nextBoolean() ? 1 : -1);
            world.addParticle(ParticleTypes.SMOKE, x2, y2, z2, 0.0D, 0.005D, 0.0D);
        }
    }
}

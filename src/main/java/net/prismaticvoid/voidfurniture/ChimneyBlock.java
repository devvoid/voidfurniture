package net.prismaticvoid.voidfurniture;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class ChimneyBlock extends Block {
    public static final VoxelShape SHAPE;

    static {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0, 0, 1, 0.375, 1));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.375, 0.25, 0.75, 0.5625, 0.75));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.5625, 0.0625, 0.9375, 0.875, 0.9375));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.875, 0.0625, 0.125, 1, 0.9375));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.875, 0.875, 0.0625, 0.9375, 1, 0.9375));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.125, 0.875, 0.0625, 0.875, 1, 0.125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.125, 0.875, 0.875, 0.875, 1, 0.9375));

        SHAPE = shape;
    }
    public ChimneyBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextFloat() < 1F) {
            for(int i = 0; i < random.nextInt(4) + 2; ++i) {
                world.addImportantParticle(
                        ParticleTypes.CAMPFIRE_COSY_SMOKE,
                        true,
                        (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1),
                        (double)pos.getY() + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1),
                        0.01D, 0.07D, 0.01D);
            }
        }
    }
}

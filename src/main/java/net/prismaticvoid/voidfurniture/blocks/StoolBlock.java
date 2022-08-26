package net.prismaticvoid.voidfurniture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class StoolBlock extends Block {
    private static final VoxelShape SHAPE;

    static {
        var s1 = VoxelShapes.cuboid(0.125, 0.625, 0.125, 0.875, 0.75, 0.875);
        var s2 = VoxelShapes.cuboid(0.125, 0, 0.125, 0.25, 0.625, 0.25);
        var s3 = VoxelShapes.cuboid(0.75, 0, 0.125, 0.875, 0.625, 0.25);
        var s4 = VoxelShapes.cuboid(0.75, 0, 0.75, 0.875, 0.625, 0.875);
        var s5 = VoxelShapes.cuboid(0.125, 0, 0.75, 0.25, 0.625, 0.875);
        var s6 = VoxelShapes.cuboid(0.25, 0.1875, 0.1875, 0.75, 0.3125, 0.25);
        var s7 = VoxelShapes.cuboid(0.25, 0.1875, 0.75, 0.75, 0.3125, 0.8125);
        var s8 = VoxelShapes.cuboid(0.1875, 0.1875, 0.25, 0.25, 0.3125, 0.75);
        var s9 = VoxelShapes.cuboid(0.75, 0.1875, 0.25, 0.8125, 0.3125, 0.75);

        SHAPE = VoxelShapes.union(s1, s2, s3, s4, s5, s6, s7, s8, s9);
    }

    public StoolBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}

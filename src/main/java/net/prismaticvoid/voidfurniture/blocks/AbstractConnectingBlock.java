package net.prismaticvoid.voidfurniture.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.prismaticvoid.voidfurniture.blocks.enums.Sides;

import java.util.HashMap;

public abstract class AbstractConnectingBlock extends HorizontalFacingBlock {
    protected static final EnumProperty<Sides> SIDES = EnumProperty.of("sides", Sides.class);

    // Gets which direction is "left" or "right" relative to the block's facing direction
    private static final HashMap<Direction, Direction> LEFT_DIRECTIONS;
    private static final HashMap<Direction, Direction> RIGHT_DIRECTIONS;

    static {
        LEFT_DIRECTIONS = new HashMap<>();
        LEFT_DIRECTIONS.put(Direction.NORTH, Direction.WEST);
        LEFT_DIRECTIONS.put(Direction.EAST, Direction.NORTH);
        LEFT_DIRECTIONS.put(Direction.SOUTH, Direction.EAST);
        LEFT_DIRECTIONS.put(Direction.WEST, Direction.SOUTH);

        RIGHT_DIRECTIONS = new HashMap<>();
        RIGHT_DIRECTIONS.put(Direction.NORTH, Direction.EAST);
        RIGHT_DIRECTIONS.put(Direction.EAST, Direction.SOUTH);
        RIGHT_DIRECTIONS.put(Direction.SOUTH, Direction.WEST);
        RIGHT_DIRECTIONS.put(Direction.WEST, Direction.NORTH);
    }

    // Block tag of blocks this can connect to
    protected final TagKey<Block> CONNECTING_BLOCK;

    public AbstractConnectingBlock(Settings settings, TagKey<Block> connectingBlock) {
        super(settings);

        CONNECTING_BLOCK = connectingBlock;

        setDefaultState(
                this.stateManager.getDefaultState()
                        .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                        .with(SIDES, Sides.BOTH)
        );
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        var world = ctx.getWorld();
        var pos = ctx.getBlockPos();
        var facing = ctx.getPlayerFacing().getOpposite();

        var left = LEFT_DIRECTIONS.get(facing);
        var right = RIGHT_DIRECTIONS.get(facing);

        var block_left = pos.offset(left);
        var block_right = pos.offset(right);

        var needs_left = !canConnect(world.getBlockState(block_left));
        var needs_right = !canConnect(world.getBlockState(block_right));

        Sides sides_state;

        if (needs_left && needs_right) {
            sides_state = Sides.BOTH;
        }
        else if (needs_left) {
            sides_state = Sides.LEFT;
        }
        else if (needs_right) {
            sides_state = Sides.RIGHT;
        }
        else {
            sides_state = Sides.NONE;
        }

        return this.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite())
                .with(SIDES, sides_state);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        var facing = state.get(Properties.HORIZONTAL_FACING);

        var block_left = pos.offset(LEFT_DIRECTIONS.get(facing));
        var block_right = pos.offset(RIGHT_DIRECTIONS.get(facing));

        var needs_left = !canConnect(world.getBlockState(block_left));
        var needs_right = !canConnect(world.getBlockState(block_right));

        Sides sides_state;

        if (needs_left && needs_right) {
            sides_state = Sides.BOTH;
        }
        else if (needs_right) {
            sides_state = Sides.LEFT;
        }
        else if (needs_left) {
            sides_state = Sides.RIGHT;
        }
        else {
            sides_state = Sides.NONE;
        }

        return state.with(SIDES, sides_state);
    }

    protected Boolean canConnect(BlockState state) {
        return state.isIn(CONNECTING_BLOCK);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING, SIDES);
    }
}

package net.prismaticvoid.voidfurniture.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.world.World;
import net.prismaticvoid.voidfurniture.BlockEntityRegistry;
import org.jetbrains.annotations.Nullable;

public class ModdedCampfireBlock extends CampfireBlock {
    public ModdedCampfireBlock(boolean emitsParticles, int fireDamage, Settings settings) {
        super(emitsParticles, fireDamage, settings);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient) {
            return state.get(LIT) ? checkType(type, BlockEntityRegistry.CAMPFIRE, CampfireBlockEntity::clientTick) : null;
        } else {
            return state.get(LIT) ? checkType(type, BlockEntityRegistry.CAMPFIRE, CampfireBlockEntity::litServerTick) : checkType(type, BlockEntityRegistry.CAMPFIRE, CampfireBlockEntity::unlitServerTick);
        }
    }
}

package net.prismaticvoid.voidfurniture;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.util.registry.Registry;

public class BlockEntityRegistry {
    public static final BlockEntityType<CampfireBlockEntity> CAMPFIRE = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            Utils.id("campfire"),
            FabricBlockEntityTypeBuilder.create(CampfireBlockEntity::new, BlockRegistry.get("oak_campfire")).build()
    );

    // This prevents a crash, but otherwise doesn't seem to be necessary
    public static void init() {

        VoidFurnitureMod.LOGGER.info("Registering block entities");
    }
}

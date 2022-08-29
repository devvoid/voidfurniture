package net.prismaticvoid.voidfurniture.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.prismaticvoid.voidfurniture.BlockRegistry;

public class LootTableGenerator extends FabricBlockLootTableProvider {
    protected LootTableGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {
        for(var i : BlockRegistry.BLOCKS.)
    }
}

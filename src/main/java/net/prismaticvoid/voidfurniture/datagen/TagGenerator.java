package net.prismaticvoid.voidfurniture.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.prismaticvoid.voidfurniture.BlockRegistry;
import net.prismaticvoid.voidfurniture.Utils;

public class TagGenerator extends FabricTagProvider.BlockTagProvider {
    private static final TagKey<Block> BENCHES_TAG  = TagKey.of(Registry.BLOCK_KEY, Utils.id("benches"));
    protected TagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        var builder = getOrCreateTagBuilder(BENCHES_TAG);

        for (var block : BlockRegistry.BLOCKS.entrySet()) {
            var key = block.getKey();

            if (key.contains("bench")) {
                builder.add(block.getValue());
            }
        }
    }

    protected void create(String name) {

    }
}

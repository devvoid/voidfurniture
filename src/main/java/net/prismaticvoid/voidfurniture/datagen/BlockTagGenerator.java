package net.prismaticvoid.voidfurniture.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.prismaticvoid.voidfurniture.BlockRegistry;
import net.prismaticvoid.voidfurniture.Utils;
import net.prismaticvoid.voidfurniture.VoidFurnitureMod;

import java.util.HashMap;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    private static final HashMap<String, TagKey<Block>> BLOCK_TAGS = new HashMap<>();

    public BlockTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        createBlockTag("chimneys", "chimney");
        createBlockTag("plant_pots", "plant_pot");

        // Lighting
        createBlockTag("candlesticks", "candlestick");
        createBlockTag("fairy_lights", "fairy_light");

        createMetaBlockTag("lighting", "candlesticks", "fairy_lights");

        // Seating
        createBlockTag("benches", "bench");
        createBlockTag("sofas", "sofa");
        createBlockTag("chairs", "chair");
        createBlockTag("stools", "stool");
        createBlockTag("floor_cushions", "floor_cushion");

        createMetaBlockTag("seating", "benches", "chairs", "stools", "floor_cushions");

        // Tables
        createBlockTag("table_centers", "table_center");
        createBlockTag("table_corners", "table_corner");
        createBlockTag("table_edges", "table_edge");

        createMetaBlockTag("tables", "table_centers", "table_corners", "table_edges");
    }

    protected void createBlockTag(String tag_name, String block_pattern) {
        var tag = TagKey.of(Registry.BLOCK_KEY, Utils.id(tag_name));

        var builder = getOrCreateTagBuilder(tag);

        for (var block : BlockRegistry.BLOCKS.entrySet()) {
            var key = block.getKey();

            if (key.contains(block_pattern)) {
                builder.add(block.getValue());
            }
        }

        BLOCK_TAGS.put(tag_name, tag);
    }

    protected void createMetaBlockTag(String tag_name, String... tags) {
        var metatag = TagKey.of(Registry.BLOCK_KEY, Utils.id(tag_name));

        var b = getOrCreateTagBuilder(metatag);

        for (var i : tags) {
            b.addTag(getBlockTag(i));
        }

        BLOCK_TAGS.put(tag_name, metatag);
    }

    public TagKey<Block> getBlockTag(String name) {
        var t = BLOCK_TAGS.get(name);

        if (t == null) {
            VoidFurnitureMod.LOGGER.error("Invalid block tag '" + name + "' requested!!");
        }

        return t;
    }
}

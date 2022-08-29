package net.prismaticvoid.voidfurniture.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.prismaticvoid.voidfurniture.BlockRegistry;
import net.prismaticvoid.voidfurniture.ItemRegistry;
import net.prismaticvoid.voidfurniture.Utils;

import java.util.HashMap;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    private static final HashMap<String, TagKey<Item>> ITEM_TAGS = new HashMap<>();

    public ItemTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        createItemTag("floor_cushions", "floor_cushion");
    }

    protected void createItemTag(String tag_name, String item_pattern) {
        var tag = TagKey.of(Registry.ITEM_KEY, Utils.id(tag_name));

        var builder = getOrCreateTagBuilder(tag);

        for (var block : ItemRegistry.ITEMS.entrySet()) {
            var key = block.getKey();

            if (key.contains(item_pattern)) {
                builder.add(block.getValue());
            }
        }

        ITEM_TAGS.put(tag_name, tag);
    }
}

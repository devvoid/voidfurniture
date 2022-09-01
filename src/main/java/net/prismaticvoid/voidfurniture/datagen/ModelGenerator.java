package net.prismaticvoid.voidfurniture.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.prismaticvoid.voidfurniture.BlockRegistry;
import net.prismaticvoid.voidfurniture.Utils;
import net.prismaticvoid.voidfurniture.blocks.BenchBlock;
import net.prismaticvoid.voidfurniture.blocks.ChairBlock;
import net.prismaticvoid.voidfurniture.blocks.enums.BenchSides;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) {
        for (var i : BlockRegistry.BLOCKS.entrySet()) {
            var name = i.getKey();

            if (name.endsWith("chair")) {
                registerChair(name, gen);
                continue;
            }

            if (name.endsWith("bench")) {
                registerBench(name, gen);
                continue;
            }

            if (name.endsWith("table_corner") || name.endsWith("table_edge")) {
                registerRotatedBlock(name, gen, true);
                continue;
            }

            gen.registerSimpleState(BlockRegistry.get(name));
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }

    public static void registerChair(String name, BlockStateModelGenerator generator) {
        var id = Utils.id("block/" + name);
        var id_scooted = Utils.id("block/" + name + "_scooted");

        var coord1 = BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates();
        var coord2 = BlockStateVariantMap.create(ChairBlock.SCOOTED)
                .register(true, BlockStateVariant.create().put(VariantSettings.MODEL, id_scooted))
                .register(false, BlockStateVariant.create().put(VariantSettings.MODEL, id));

        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(BlockRegistry.get(name))
                        .coordinate(coord1)
                        .coordinate(coord2)
        );
    }

    public static void registerBench(String name, BlockStateModelGenerator generator) {
        var id = Utils.id("block/" + name);
        var id_left = Utils.id("block/" + name + "_left");
        var id_right = Utils.id("block/" + name + "_right");
        var id_none = Utils.id("block/" + name + "_none");

        var coord1 = BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates();
        var coord2 = BlockStateVariantMap.create(BenchBlock.SIDES)
                .register(BenchSides.BOTH, BlockStateVariant.create().put(VariantSettings.MODEL, id))
                .register(BenchSides.LEFT, BlockStateVariant.create().put(VariantSettings.MODEL, id_left))
                .register(BenchSides.RIGHT, BlockStateVariant.create().put(VariantSettings.MODEL, id_right))
                .register(BenchSides.NONE, BlockStateVariant.create().put(VariantSettings.MODEL, id_none));

        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(BlockRegistry.get(name))
                        .coordinate(coord1)
                        .coordinate(coord2)
        );
    }

    public static void registerFloorCandlestick(String name, BlockStateModelGenerator generator) {

    }

    public static void registerWallCandlestick(String name, BlockStateModelGenerator generator) {

    }

    public static void registerRotatedBlock(String name, BlockStateModelGenerator generator, boolean uvlock) {
        var id = Utils.id("block/" + name);

        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(
                        BlockRegistry.get(name),
                                BlockStateVariant.create().put(VariantSettings.MODEL, id)
                        )
                        .coordinate(makeRotationStates(uvlock))
        );
    }

    public static BlockStateVariantMap makeRotationStates() {
        return makeRotationStates(false);
    }

    public static BlockStateVariantMap makeRotationStates(boolean uvlock) {
        return BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
                .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, uvlock))
                .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, uvlock))
                .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, uvlock))
                .register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.UVLOCK, uvlock));
    }
}

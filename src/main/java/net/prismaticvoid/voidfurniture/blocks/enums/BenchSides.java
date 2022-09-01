package net.prismaticvoid.voidfurniture.blocks.enums;

import net.minecraft.util.StringIdentifiable;

public enum BenchSides implements StringIdentifiable {
    NONE,
    LEFT,
    RIGHT,
    BOTH;

    public String toString() {
        return this.asString();
    }

    @Override
    public String asString() {
        return switch (this) {
            case NONE -> "none";
            case LEFT -> "left";
            case RIGHT -> "right";
            case BOTH -> "both";
        };
    }
}

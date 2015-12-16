package com.hotfixs.thinkinginjava.generics.bounds;

import java.awt.Color;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
interface HasColor {
    Color getColor();
}

class Colored<T extends HasColor> {
    T item;

    Colored(T item) {
        this.item = item;
    }

    Color color() {
        return item.getColor();
    }
}

class Dimension {
    public int x, y, z;
}

// illegal: class must be the first, then interfaces
// class ColoredDimension<T extends HasColor & Dimension> {}

class ColoredDimension<T extends Dimension & HasColor> {
    T item;

    ColoredDimension(T item) {
        this.item = item;
    }

    Color getColor() {
        return item.getColor();
    }

    T getItem() {
        return item;
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}

// As with inheritance, you can have only concrete class, but multiple interfaces
class Solid<T extends Dimension & HasColor & Weight> {
    T item;

    Solid(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

    Color getColor() {
        return item.getColor();
    }

    int weight() {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor, Weight {

    @Override
    public Color getColor() {
        return Color.black;
    }

    @Override
    public int weight() {
        return 0;
    }
}

public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.getColor();
        solid.weight();
        solid.getY();
    }
}

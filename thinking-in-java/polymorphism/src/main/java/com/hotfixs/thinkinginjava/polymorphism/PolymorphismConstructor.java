package com.hotfixs.thinkinginjava.polymorphism;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */
class Glyph {
    void draw() {
        print("Glyph draw");
    }

    Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius;

    RoundGlyph(int radius) {
        this.radius = radius;
        print("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        print("RoundGlyph.draw(), radius = " + radius);
    }
}

public class PolymorphismConstructor {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

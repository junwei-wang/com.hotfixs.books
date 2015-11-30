package com.hotfixs.thinkinginjava.polymorphism;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */

class Characteristic {
    private String s;

    Characteristic(String s) {
        this.s = s;
        print("Creating Characteristic: " + s);
    }

    protected void dispose() {
        print("disposing Characteristic: " + s);
    }
}

class Description {
    private String s;

    Description(String s) {
        this.s = s;
        print("Creating Description: " + s);
    }

    protected void dispose() {
        print("disposing Description: " + s);
    }
}

class LivingCreature {
    Characteristic p = new Characteristic("is alive");
    Description t = new Description("Basic Living Creature");

    LivingCreature() {
        print("LivingCreature()");
    }

    protected void dispose() {
        print("LivingCreature dispose");
        t.dispose();
        p.dispose();
    }
}

class Animal extends LivingCreature {
    Characteristic p = new Characteristic("has heart");
    Description t = new Description("Animal not Vegetables");

    Animal() {
        print("Animal()");
    }

    @Override
    protected void dispose() {
        print("Animal dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

public class Frog extends Animal {
    Characteristic p = new Characteristic("Croaks");
    Description t = new Description("Eats Bugs");

    Frog() {
        print("Frog()");
    }

    @Override
    protected void dispose() {
        print("Frog dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        print("bye");
        frog.dispose();
    }

}



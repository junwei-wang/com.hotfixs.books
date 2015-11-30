package com.hotfixs.thinkinginjava.access;

/**
 * @author wang
 */
public class IceCream {
    public static void main(String[] args) {
        Sundae x = Sundae.makeASundea();
        // ! Sundae y = new Sundae();
    }
}

class Sundae {
    private Sundae() {
    }

    static Sundae makeASundea() {
        return new Sundae();
    }
}

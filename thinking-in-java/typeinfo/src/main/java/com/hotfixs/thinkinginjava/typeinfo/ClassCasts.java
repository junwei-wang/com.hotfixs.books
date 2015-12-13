package com.hotfixs.thinkinginjava.typeinfo;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
class Building {
}

class House extends Building {
}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseClass = House.class;
        House h = houseClass.cast(b);
        h = (House) b; // or, just do this
    }
}

package com.hotfixs.thinkinginjava.generics.erasure;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
    private Class<T> type;

    public ClassTypeCapture(Class<T> type) {
        this.type = type;
    }

    public boolean f(Object arg) {
        return type.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> capture1 = new ClassTypeCapture<>(Building.class);
        print(capture1.f(new Building()));
        print(capture1.f(new House()));

        ClassTypeCapture<House> capture2 = new ClassTypeCapture<>(House.class);
        print(capture2.f(new Building()));
        print(capture2.f(new House()));
    }
}

package com.hotfixs.thinkinginjava.generics;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

class SimpleManipulator {
    private HasF obj;

    public SimpleManipulator(HasF obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }
}

public class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }

    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();

        SimpleManipulator simpleManipulator = new SimpleManipulator(hf);
        simpleManipulator.manipulate();
    }
}

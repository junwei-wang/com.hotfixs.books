package com.hotfixs.thinkinginjava.polymorphism;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */
public class StaticBinding {
    static void staticMethodBinding(Parent parent) {
        parent.doSomething();
    }

    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();

        staticMethodBinding(p);
        staticMethodBinding(c);
    }
}

class Parent {
    static void doSomething() {
        print("parent");
    }
}

class Child extends Parent {
    // ! @Override
    static void doSomething() {
        print("child");
    }
}
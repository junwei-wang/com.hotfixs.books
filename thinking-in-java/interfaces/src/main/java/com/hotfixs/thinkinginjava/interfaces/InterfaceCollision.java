package com.hotfixs.thinkinginjava.interfaces;

/**
 * @author wang
 */

class C2 implements I1, I2 {
    @Override
    public void f() {
    }

    @Override
    public int f(int i) {
        return i;
    }
}

class C3 extends C implements I2 {
    @Override
    public int f(int i) {
        return i;
    }
}

class C4 extends C implements I3 {
    // identical, no problem
    @Override
    public int f() {
        return 0;
    }
}

// Method differs only by return type
// class C5 extends C implements I1 {}
// class C6 implements I1, I3;

public class InterfaceCollision {
}

interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C {
    int f() {
        return 1;
    }
}


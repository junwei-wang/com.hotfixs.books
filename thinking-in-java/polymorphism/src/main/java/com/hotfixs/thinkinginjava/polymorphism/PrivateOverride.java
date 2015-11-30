package com.hotfixs.thinkinginjava.polymorphism;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */
public class PrivateOverride {
    private void f() {
        print("private f");
    }

    public static void main(String[] args) {
        PrivateOverride po = new PrivateOverride();
        po.f();
    }
}

class Derived extends PrivateOverride {
    public void f() {
        print("public f");
    }
}

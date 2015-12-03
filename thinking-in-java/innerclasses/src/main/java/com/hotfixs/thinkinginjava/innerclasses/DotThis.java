package com.hotfixs.thinkinginjava.innerclasses;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */
public class DotThis {
    void f() {
        print("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        DotThis.Inner inner = dotThis.inner();
        inner.outer().f();
    }
}

package com.hotfixs.thinkinginjava.generics.selfbounded;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
// 限定T必须为SelfBounded类型
class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends SelfBounded<A> {
}

class B extends SelfBounded<A> {
}

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {
}

// illegal: class E extends SelfBounded<D> {}

class F extends SelfBounded {
}

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        print(a);
        a.set(new A());
        a = a.set(new A()).get();
        print(a);
        a = a.get();
        print(a);

        C c = new C();
        print(c);
        c = c.setAndGet(new C());
        print(c);
    }
}

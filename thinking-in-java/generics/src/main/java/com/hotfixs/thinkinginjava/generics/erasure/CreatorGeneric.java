package com.hotfixs.thinkinginjava.generics.erasure;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

// 模板方法
abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {
}

class Creator extends GenericWithCreate<X> {

    @Override
    X create() {
        return new X();
    }

    void f() {
        print(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}

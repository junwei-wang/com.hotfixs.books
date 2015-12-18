package com.hotfixs.thinkinginjava.generics.crg;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class BasicHolder<T> {
    T element;

    void set(T arg) {
        this.element = arg;
    }

    T get() {
        return this.element;
    }

    void f() {
        print(element.getClass().getSimpleName());
    }
}

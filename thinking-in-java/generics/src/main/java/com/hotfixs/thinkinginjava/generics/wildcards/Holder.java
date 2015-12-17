package com.hotfixs.thinkinginjava.generics.wildcards;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Holder<T> {
    private T item;

    public Holder() {
    }

    public Holder(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    // generic method parameter
    public void set(T item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        return item.equals(o);
    }

    public static void main(String[] args) {
        Holder<Integer> integer = new Holder<>(1);
        Integer i = integer.get();
        integer.set(i);

        // Holder<Number> number = integer; // cannot upcast
        Holder<? extends Number> number = integer;
        Integer i2 = (Integer) number.get();

        try {
            Short bool = (Short) number.get();
        } catch (Exception e) {
            print(e);
        }
        // number.set(1);   // cannot call set()
        // number.set(1.2f); // cannot call set()
        print(number.equals(1));
    }
}

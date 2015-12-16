package com.hotfixs.thinkinginjava.generics.wildcards;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Holder<T> {
    private T item;

    public Holder(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    // generic method parameter
    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        return item.equals(o);
    }

    public static void main(String[] args) {
        Holder<Integer> integer = new Holder<>(1);
        Integer i = integer.getItem();
        integer.setItem(i);

        // Holder<Number> number = integer; // cannot upcast
        Holder<? extends Number> number = integer;
        Integer i2 = (Integer) number.getItem();

        try {
            Short bool = (Short) number.getItem();
        } catch (Exception e) {
            print(e);
        }
        // number.setItem(1);   // cannot call setItem()
        // number.setItem(1.2f); // cannot call setItem()
        print(number.equals(1));
    }
}

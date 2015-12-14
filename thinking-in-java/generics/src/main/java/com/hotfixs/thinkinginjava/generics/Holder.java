package com.hotfixs.thinkinginjava.generics;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Holder<T> {
    private T a;

    public Holder(T a) {
        this.a = a;
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        Holder<String> stringHolder = new Holder<>("abc");
        String str = stringHolder.get();
        stringHolder.set("edf");
    }
}

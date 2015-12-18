package com.hotfixs.thinkinginjava.generics.selfbounded;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class SelfBoundingMethods {
    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
    }
}

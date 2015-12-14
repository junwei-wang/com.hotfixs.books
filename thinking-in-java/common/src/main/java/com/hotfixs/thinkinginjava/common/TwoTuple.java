package com.hotfixs.thinkinginjava.common;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

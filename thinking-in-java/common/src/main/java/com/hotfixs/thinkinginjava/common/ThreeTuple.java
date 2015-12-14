package com.hotfixs.thinkinginjava.common;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + "," + third + ")";
    }
}

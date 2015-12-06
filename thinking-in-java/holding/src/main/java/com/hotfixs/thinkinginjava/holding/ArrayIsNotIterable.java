package com.hotfixs.thinkinginjava.holding;

import static com.hotfixs.thinkinginjava.common.Print.printnb;

import java.util.Arrays;

/**
 * @author wang
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> i) {
        for (T t : i) {
            printnb(t + "");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        // test([1, 2, 3]);
    }
}

package com.hotfixs.thinkinginjava.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class SuperTypeWildcards {
    public static void main(String[] args) {
        List<? super Integer> list = new ArrayList<>();
        list.add(1);
        // illegal
        /*
        list.add(new Number() {
            @Override
            public int intValue() {
                return 0;
            }

            @Override
            public long longValue() {
                return 0;
            }

            @Override
            public float floatValue() {
                return 0;
            }

            @Override
            public double doubleValue() {
                return 0;
            }
        });
        */
        // list.add(1.2f); // Number object is not allowed
    }
}

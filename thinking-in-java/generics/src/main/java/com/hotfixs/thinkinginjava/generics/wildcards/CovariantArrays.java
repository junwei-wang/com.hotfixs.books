package com.hotfixs.thinkinginjava.generics.wildcards;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

public class CovariantArrays {
    public static void main(String[] args) {
        // up cast an array is not a correct way to use array,
        // because an array with remember what it holds
        Number[] array = new Integer[3];  // covariant arrays
        array[0] = 1;

        // runtime exception: ArrayStoreException
        try {
            array[1] = 1.2;
        } catch (Exception e) {
            print(e);
        }

        // runtime exception: ArrayStoreException
        try {
            array[2] = new Number() {
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
            };
        } catch (Exception e) {
            print(e);
        }

        // illegal: ArrayList<Integer> is not a subclass of ArrayList<Number>
        // ArrayList<Number> list = new ArrayList<Integer>();

        // cannot add anything to the covariant generics
        List<? extends Number> list = new ArrayList<Integer>();
        // illegal: list.add(1.2);
        // illegal: list.add(1);
        list.add(null);
        Number n = list.get(0);
    }
}

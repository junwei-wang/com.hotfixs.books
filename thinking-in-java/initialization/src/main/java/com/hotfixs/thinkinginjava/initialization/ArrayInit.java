package com.hotfixs.thinkinginjava.initialization;

import java.util.Arrays;

/**
 * @author wang
 */
public class ArrayInit {
    public static void main(String[] args) {
        Integer[] a = {
                new Integer(1),
                new Integer(2),
                3, // auto-boxing
        };

        Integer[] b = new Integer[] {
                new Integer(1),
                new Integer(2),
                3, // auto-boxing
        };

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}

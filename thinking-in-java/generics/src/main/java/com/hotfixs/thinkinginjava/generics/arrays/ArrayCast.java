package com.hotfixs.thinkinginjava.generics.arrays;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ArrayCast {
    public static void main(String[] args) {
        Object[] arr = new Integer[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = i;
        }
        Integer[] arr2 = (Integer[]) arr;

        Object[] arr3 = new Object[5];
        for (int i = 0; i < 5; i++) {
            arr3[i] = i;
        }
        Integer[] arr4 = (Integer[]) arr3
                ;
    }
}

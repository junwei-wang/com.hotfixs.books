package com.hotfixs.thinkinginjava.generics.arrays;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ArrayMaker<T> {
    private Class<T> type; // will be erased

    public ArrayMaker(Class<T> type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public T[] createArray(int size) {
        return (T[]) Array.newInstance(type, 9); // the recommended way
    }

    public static void main(String[] args) {
        ArrayMaker<String> arrayMaker = new ArrayMaker<>(String.class);
        String[] arr = arrayMaker.createArray(10);
        print(Arrays.toString(arr));

        ArrayMaker<Integer> arrayMaker2 = new ArrayMaker<>(Integer.class);
        Integer[] arr2 = arrayMaker2.createArray(10);
        print(Arrays.toString(arr2));
    }
}

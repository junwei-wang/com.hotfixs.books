package com.hotfixs.thinkinginjava.generics.arrays;

import java.lang.reflect.Array;

/**
 * The recommend way to create generic array
 *
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    public GenericArrayWithTypeToken(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
        Integer[] ia = gai.rep();
    }
}

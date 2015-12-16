package com.hotfixs.thinkinginjava.generics.arrays;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class GenericArray<T> {
    private Object[] array;

    public GenericArray(int size) {
        array = new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> array = new GenericArray<>(10);
        for (int i = 0; i < 10; i++) {
            array.put(i, i * i);
        }
        for (int i = 0; i < 10; i++) {
            print(array.get(i));
        }
        try {
            Integer[] array2 = array.rep();
        } catch (Exception e) {
            print(e);
        }
    }
}

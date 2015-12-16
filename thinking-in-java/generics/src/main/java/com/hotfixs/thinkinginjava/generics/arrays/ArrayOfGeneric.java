package com.hotfixs.thinkinginjava.generics.arrays;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
class Generic<T> {
}

public class ArrayOfGeneric {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Generic<String>[] arr = (Generic<String>[]) new Generic[10];

        // runtime error: ClassCastException
        Generic<String>[] arr1 = (Generic<String>[]) new Object[10];

        arr[0] = new Generic<>();

        // compile error
        // arr[1] = new Generic<Integer>();
        // arr[2] = new Object();
    }
}

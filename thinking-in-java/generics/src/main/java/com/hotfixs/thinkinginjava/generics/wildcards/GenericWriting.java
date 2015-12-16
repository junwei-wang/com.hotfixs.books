package com.hotfixs.thinkinginjava.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static List<Integer> integerList = new ArrayList<>();
    static List<Number> numberList = new ArrayList<>();

    public static void main(String[] args) {
        Integer integer = 1;

        writeExact(integerList, integer);
        writeExact(numberList, integer);
        numberList.add(integer);

        writeWithWildcard(integerList, integer);
        writeWithWildcard(numberList, integer);
    }
}

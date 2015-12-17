package com.hotfixs.thinkinginjava.generics.wildcards;

import java.util.Arrays;
import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class GenericReading {
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Integer> integers = Arrays.asList(1);
    static List<Number> numbers = Arrays.asList(new Double(1));

    static void f1() {
        Integer integer = readExact(integers);
        Number number = readExact(numbers);
        number = readExact(integers); // up cast
    }

    // however, if we have a class, then its type is established when the class is instantiated.
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Number> numberReader = new Reader<>();
        numberReader.readExact(numbers);

        // numberReader.readCovariant(integers); // error
        // readCovariant(List<Fruit>) cannot be applied to readCovariant(List<Apple>)
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Number> numberCovariantReader = new CovariantReader<>();
        Number number = numberCovariantReader.readCovariant(numbers);
        number = numberCovariantReader.readCovariant(integers);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}

package com.hotfixs.thinkinginjava.generics;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.ArrayList;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class<?> c1 = new ArrayList<Integer>().getClass();
        Class<?> c2 = new ArrayList<String>().getClass();
        print(c1.equals(c2));
        print(c1.equals(ArrayList.class));
    }
}

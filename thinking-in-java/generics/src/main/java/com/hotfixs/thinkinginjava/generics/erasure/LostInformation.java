package com.hotfixs.thinkinginjava.generics.erasure;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

class Test<TYPE_A extends Number, TYPE_B> {
}

public class LostInformation {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Test<Integer, Double> test = new Test<>();

        print(Arrays.toString(list.getClass().getTypeParameters()));
        print(Arrays.toString(test.getClass().getTypeParameters()));
    }
}

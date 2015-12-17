package com.hotfixs.thinkinginjava.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign1(List list) {
        list1 = list;
        list2 = list;
        // warning
        list3 = list;
        // compiler error
        // list3.add(1);
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    /**
     * List == List<Object> ~= List<?> != List<? extends Object>
     */

    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList());
        // warning
        assign3(new ArrayList());

        assign1(new ArrayList<String>());
        assign2(new ArrayList<String>());
        assign3(new ArrayList<String>());

        List<?> wildList = new ArrayList();
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);
    }
}

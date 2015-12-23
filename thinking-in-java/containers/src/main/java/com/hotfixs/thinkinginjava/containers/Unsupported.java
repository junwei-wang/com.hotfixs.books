package com.hotfixs.thinkinginjava.containers;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Unsupported {
    static void test(String msg, List<String> list) {
        print("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> sublist = list.subList(1, 8);
        Collection<String> c2 = new ArrayList<>(sublist);

        try {
            c.retainAll(c2);
        } catch (Exception e) {
            print("retainAll(): " + e);
        }

        try {
            c.removeAll(c2);
        } catch (Exception e) {
            print("removeAll(): " + e);
        }

        try {
            c.clear();
        } catch (Exception e) {
            print("clear(): " + e);
        }

        try {
            c.add("X");
        } catch (Exception e) {
            print("add(): " + e);
        }

        try {
            c.addAll(c2);
        } catch (Exception e) {
            print("addAll(): " + e);
        }

        try {
            c.remove("C");
        } catch (Exception e) {
            print("remove(): " + e);
        }

        try {
            list.set(0, "X");
        } catch (Exception e) {
            print("set(): " + e);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L M N".split(" "));
        test("Modifiable Copy", new ArrayList<>(list));
        test("Arrays.asList()", list);
        test("Collections.unmodifiableList()", Collections.unmodifiableList(list));
    }
}

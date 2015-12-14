package com.hotfixs.thinkinginjava.generics;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class GenericMethods {
    public <T> void getClass(T t) {
        print(t.getClass().getSimpleName());
    }


    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.getClass(1);
        gm.getClass(1.2);
        gm.getClass(1.2f);
        gm.getClass(true);
        gm.getClass("abc");
        gm.getClass(gm);
    }
}

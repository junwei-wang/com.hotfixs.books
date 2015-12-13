package com.hotfixs.thinkinginjava.typeinfo;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.lang.reflect.Field;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
class WithPrivateFinalField {
    private int i = 1;
    private final String s1 = "I am totally safe!";
    private String s2 = "Am I safe??";

    @Override
    public String toString() {
        return "i = " + i + ", s1 = " + s1 + ", s2 = " + s2;
    }
}

public class ModifyPrivateFields {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        WithPrivateFinalField o = new WithPrivateFinalField();

        Field f = o.getClass().getDeclaredField("i");
        f.setAccessible(true);
        f.set(o, 10);
        print(o);

        f = o.getClass().getDeclaredField("s1");
        f.setAccessible(true);
        f.set(o, "you are not safe");
        print(o);

        f = o.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        f.set(o, "you are not safe");
        print(o);
    }
}

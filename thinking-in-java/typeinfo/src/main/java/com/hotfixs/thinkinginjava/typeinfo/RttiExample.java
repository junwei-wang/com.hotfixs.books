package com.hotfixs.thinkinginjava.typeinfo;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class RttiExample {
    public static void main(String[] args) throws ClassNotFoundException {
        // multiple ways to get the Class object
        System.out.println(String.class.getCanonicalName());
        System.out.println(Class.forName("java.lang.String").getCanonicalName());
        String test = "test";
        System.out.println(test.getClass().getCanonicalName());

        // type test
        System.out.println(test instanceof String);
        System.out.println(String.class.isInstance(test));
        System.out.println(test.getClass().equals(String.class));
        System.out.println(test.getClass().equals(CharSequence.class));

        // generic Class reference to ensure compile check
        Class<? extends CharSequence> cc = String.class;
    }
}

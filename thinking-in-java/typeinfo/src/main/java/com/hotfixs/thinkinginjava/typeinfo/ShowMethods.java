package com.hotfixs.thinkinginjava.typeinfo;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ShowMethods {
    private static String usage =
            "usage:\n" +
                    "To show all methods in class or:\n" +
                    "  java ShowMethods qualified.class.name";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            print(usage);
            System.exit(1);
        }

        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();

            if (args.length == 1) {
                for (Method method : methods) {
                    print(p.matcher(method.toString()).replaceAll(""));
                }

                for (Constructor constructor : constructors) {
                    print(p.matcher(constructor.toString()).replaceAll(""));
                }
            }

        } catch (ClassNotFoundException e) {
            print("No such class: " + e);
        }
    }
}

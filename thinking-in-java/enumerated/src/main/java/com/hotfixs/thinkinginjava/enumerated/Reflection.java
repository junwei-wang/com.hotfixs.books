package com.hotfixs.thinkinginjava.enumerated;

import static com.hotfixs.thinkinginjava.common.Print.print;

import com.hotfixs.thinkinginjava.common.OsExecute;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wangjunwei
 */
enum Explore {
    HERE, THRER
}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        print("----- Analyzing " + enumClass + " -----");
        print("Interfaces:");
        print(Arrays.toString(enumClass.getGenericInterfaces()));
        print("Base: " + enumClass.getSuperclass());
        print("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        print(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);

        print("Explorer.containsAll(Enum)? :" + exploreMethods.containsAll(enumMethods));

        exploreMethods.removeAll(enumMethods);
        print("Explorer.removeAll(Enum): " + exploreMethods);

        OsExecute.command("javap thinking-in-java/enumerated"
                + "/target/classes/com/hotfixs/thinkinginjava/enumerated/Explore.class");
    }
}

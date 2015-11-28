package com.hotfixs.thinkinginjava.initialization;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

/**
 * @author wang
 */
public class VarArgs {
    static void printArray(Object... args) {
        for (Object obj : args) {
            printnb(obj + " ");
        }
        print();
    }

    public static void main(String[] args) {
        printArray(new Integer(1), new Integer(2), new Double(11.11));
        printArray("Str1", "str2", 1);
        printArray(new A(), new B(), new A());
        printArray(new String[] {"!", "?"});
        printArray();
    }
}

class A {
}

class B {
}

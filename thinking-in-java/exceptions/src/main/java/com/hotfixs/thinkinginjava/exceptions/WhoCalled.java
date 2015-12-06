package com.hotfixs.thinkinginjava.exceptions;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */
public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement element : e.getStackTrace()) {
                print(element.toString());
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();

        print("=============");
        g();

        print("=============");
        h();
    }
}

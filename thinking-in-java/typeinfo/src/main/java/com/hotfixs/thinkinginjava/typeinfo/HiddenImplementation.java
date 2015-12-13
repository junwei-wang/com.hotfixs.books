package com.hotfixs.thinkinginjava.typeinfo;

import static com.hotfixs.thinkinginjava.common.Print.print;

import com.hotfixs.thinkinginjava.typeinfo.interfaces.A;
import com.hotfixs.thinkinginjava.typeinfo.packageaccess.HiddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class HiddenImplementation {
    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = HiddenC.makeA();
        a.f();
        print(a.getClass().getCanonicalName());
        // illegal
        /*
        if (a instanceof C) {
            C c = (C)a;
            c.g();
        } */

        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    public static void callHiddenMethod(Object a, String methodName)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = a.getClass().getDeclaredMethod(methodName);
        m.setAccessible(true);
        m.invoke(a);
    }
}

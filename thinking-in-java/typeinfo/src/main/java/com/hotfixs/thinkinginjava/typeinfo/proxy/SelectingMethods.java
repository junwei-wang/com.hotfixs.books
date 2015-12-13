package com.hotfixs.thinkinginjava.typeinfo.proxy;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

class MethodSelector implements InvocationHandler {
    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interesting")) {
            print("Proxy detected the interesting method");
        }
        return method.invoke(proxied, args);
    }
}

interface Iface {
    void boring1();

    void interesting(String arg);

    void boring2();
}

class Impl implements Iface {
    @Override
    public void boring1() {
        print("boring1");
    }

    @Override
    public void interesting(String arg) {
        print("interesting " + arg);
    }

    @Override
    public void boring2() {
        print("boring2");
    }
}

public class SelectingMethods {
    public static void main(String[] args) {
        Iface iface = (Iface) Proxy.newProxyInstance(
                Iface.class.getClassLoader(),
                new Class[] {Iface.class},
                new MethodSelector(new Impl())
        );
        iface.boring1();
        iface.interesting("hah");
        iface.boring2();
    }
}

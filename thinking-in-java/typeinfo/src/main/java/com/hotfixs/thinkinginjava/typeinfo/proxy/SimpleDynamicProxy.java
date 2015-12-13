package com.hotfixs.thinkinginjava.typeinfo.proxy;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        print("**** proxy: " + proxy.getClass() + ", method " + method + ", args " + args);
        if (args != null) {
            for (Object arg : args) {
                print(" " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(), // class loader
                new Class[] {Interface.class},
                new DynamicProxyHandler(real)
        );
        consumer(proxy);
    }
}

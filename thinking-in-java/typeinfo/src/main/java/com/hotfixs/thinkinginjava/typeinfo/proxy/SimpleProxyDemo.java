package com.hotfixs.thinkinginjava.typeinfo.proxy;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        print("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        print("Simple Proxy doSomething ");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        print("Simple Proxy somethingElse");
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consume(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consume(new RealObject());
        print();
        consume(new SimpleProxy(new RealObject()));
    }
}

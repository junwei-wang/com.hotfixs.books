package com.hotfixs.thinkinginjava.innerclasses;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */

interface Incrementable {
    void increment();
}

class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        print(i);
    }
}

class MyIncrement {
    public void increment() {
        print("Other operation");
    }

    static void f(MyIncrement mi) {
        mi.increment();
    }
}

// 当Callee2已经继承了MyIncrement具有incremnt方法时,
// 再去实现Incrementable接口, 增加闭包类,不需要改变任何Callee2原来的代码
class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        print(i);
    }

    private class Closure implements Incrementable {
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackReference;

    Caller(Incrementable callbackReference) {
        this.callbackReference = callbackReference;
    }

    void call() {
        callbackReference.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 callee1 = new Callee1();
        Caller caller1 = new Caller(callee1);
        caller1.call();
        caller1.call();

        Callee2 callee2 = new Callee2();
        MyIncrement.f(callee2);
        Caller caller2 = new Caller(callee2.getCallbackReference());
        caller2.call();
        caller2.call();
    }

}

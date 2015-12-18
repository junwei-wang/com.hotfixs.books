package com.hotfixs.thinkinginjava.generics.crg;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

class Subtype extends BasicHolder<Subtype> {
}

public class CrgWithBasicHolder {
    public static void main(String[] args) {
        Subtype t1 = new Subtype();
        Subtype t2 = new Subtype();

        t1.set(t2);
        Subtype t3 = t1.get();
        t1.f();
    }
}

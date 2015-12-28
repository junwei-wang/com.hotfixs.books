package com.hotfixs.thinkinginjava.containers;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.WeakHashMap;

/**
 * @author wangjunwei
 */

class Element {
    private String ident;

    public Element(String id) {
        ident = id;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Element) && ident.equals(((Element) obj).ident);
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() throws Throwable {
        print("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {
    public Key(String id) {
        super(id);
    }
}

class Value extends Element {
    public Value(String id) {
        super(id);
    }
}

public class CanonicalMapping {
    public static void main(String[] args) throws InterruptedException {
        int size = 100;
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>(size);
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = k;
            }
            map.put(k, v);
        }
        print("==> before gc");
        System.gc();
        print("==> after gc");
    }
}

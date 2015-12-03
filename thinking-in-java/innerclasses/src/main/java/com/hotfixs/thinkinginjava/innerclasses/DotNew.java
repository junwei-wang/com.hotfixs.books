package com.hotfixs.thinkinginjava.innerclasses;

/**
 * @author wang
 */
public class DotNew {
    class Inner {
    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        Inner inner = dn.new Inner();
    }
}

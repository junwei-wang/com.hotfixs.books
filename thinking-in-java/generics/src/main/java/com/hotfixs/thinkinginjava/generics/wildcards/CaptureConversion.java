package com.hotfixs.thinkinginjava.generics.wildcards;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        print(t.getClass().getCanonicalName());
    }

    static void f2(Holder<?> holder) {
        f1(holder);
    }

    public static void main(String[] args) {
        Holder raw = new Holder<>("1");
        f2(raw);

        Holder rawBasic = new Holder(new Integer(1)); // Warning
        f2(rawBasic);

        Holder<?> wild = new Holder<Number>(1.0);
        f2(wild); // print Double not Number
    }
}

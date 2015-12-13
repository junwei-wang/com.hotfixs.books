package com.hotfixs.thinkinginjava.typeinfo.packageaccess;

import static com.hotfixs.thinkinginjava.common.Print.print;

import com.hotfixs.thinkinginjava.typeinfo.interfaces.A;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
class C implements A {

    @Override
    public void f() {
        print("public f()");
    }

    public void g() {
        print("public g()");
    }

    void u() {
        print("package u()");
    }

    private void v() {
        print("private v()");
    }

    protected void w() {
        print("protect w()");
    }
}

public class HiddenC {
    public static A makeA() {
        return new C();
    }
}

package com.hotfixs.thinkinginjava.polymorphism;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();
        print("sup.field = " + sup.field);
        print("sup.getField() = " + sup.getField());

        Sub sub = new Sub();
        print("sub.field = " + sub.field);
        print("sub.getField() = " + sub.getField());
        print("sub.getSuperField() = " + sub.getSuperField());
    }
}

class Super {
    int field = 0;

    int getField() {
        return field;
    }
}

class Sub extends Super {
    int field = 1;

    @Override
    int getField() {
        return field;
    }

    int getSuperField() {
        return super.field;
    }
}
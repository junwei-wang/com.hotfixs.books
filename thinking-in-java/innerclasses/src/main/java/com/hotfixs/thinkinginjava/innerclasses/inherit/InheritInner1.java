package com.hotfixs.thinkinginjava.innerclasses.inherit;

/**
 * @author wang
 */

class WithInner {
    class Inner1 {
    }

    class Inner2 {
        private int value;

        Inner2(int value) {
            this.value = value;
        }
    }
}

class AnotherWithInner {
    class Inner3 extends WithInner.Inner2 {

        Inner3(WithInner withInner, int value) {
            withInner.super(value);
        }
    }
}

public class InheritInner1 extends WithInner.Inner1 {
    public InheritInner1(WithInner withInner) {
        withInner.super();
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        InheritInner1 inheritInner1 = new InheritInner1(withInner);

        AnotherWithInner anotherWithInner = new AnotherWithInner();
        AnotherWithInner.Inner3 inner3 = anotherWithInner.new Inner3(withInner, 1);
    }
}

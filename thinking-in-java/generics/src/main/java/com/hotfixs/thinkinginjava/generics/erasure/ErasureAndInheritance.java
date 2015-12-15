package com.hotfixs.thinkinginjava.generics.erasure;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
class GenericBase<T extends Number> {
    private T element;

    public void set(T element) {
        this.element = element;
    }

    public T get() {
        return element;
    }
}

class Derived1<T extends Number> extends GenericBase<T> {
}

class Derived2 extends GenericBase {
}

//class Derived3 extends GenericBase<?> {
//}

public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 derived2 = new Derived2();
        derived2.set(1);

        // Error
        // derived2.set("1");
    }
}

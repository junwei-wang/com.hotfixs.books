package com.hotfixs.thinkinginjava.typeinfo.generic;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class GenericClassReference {
    public static void main(String[] args) {
        /* 1. 泛型class有引用 */
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;

        genericIntClass = intClass;
        intClass = double.class;

        // illegal
        // genericIntClass = double.class;

        /* 2. 使用通配符"?",放宽限制 */
        Class<?> someClass = int.class;
        someClass = double.class;

        /* 3. 正确限定类型引用的方法 (编译时类型检查,而不是运行时) */
        Class<? extends Number> numberClass = Number.class;
        numberClass = int.class;
        numberClass = double.class;

        // illegal, 尽管Integer类型是Number的子类,但是Integer.TYPE不是Number.class
        // Class<Number> numberClass = int.class;
    }
}

package com.hotfixs.thinkinginjava.typeinfo.toys;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> fancyToyClass = FancyToy.class;
        FancyToy fancyToy = fancyToyClass.newInstance();

        Class<? super FancyToy> superClass = fancyToyClass.getSuperclass();
        Object toy = superClass.newInstance();
        // illegal
        // Class<Toy> toyClass = fancyToyClass.getSuperclass();
        // Toy toy = superClass.newInstance();
    }
}

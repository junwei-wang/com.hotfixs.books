package com.hotfixs.thinkinginjava.generics;

import static com.hotfixs.thinkinginjava.common.Print.print;

import com.hotfixs.thinkinginjava.common.BasicGenerator;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject " + id;
    }

    public static void main(String[] args) {
        BasicGenerator<CountedObject> generator = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            print(generator.next());
        }
    }
}

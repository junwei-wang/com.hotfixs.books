package com.hotfixs.thinkinginjava.holding;

import java.util.Iterator;

/**
 * @author wang
 */
public class IterableClass implements Iterable<String> {
    protected String[] words = "And that is how we know the Earth to be banana-shaped.".split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }
}

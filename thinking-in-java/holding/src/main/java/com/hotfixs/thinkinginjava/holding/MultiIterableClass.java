package com.hotfixs.thinkinginjava.holding;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author wang
 */
public class MultiIterableClass extends IterableClass {
    public Iterable<String> reversed() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    private int index = words.length - 1;

                    @Override
                    public boolean hasNext() {
                        return index > -1;
                    }

                    @Override
                    public String next() {
                        return words[index--];
                    }
                };
            }
        };
    }

    public Iterable<String> randomize() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        for (String s : mic) {
            printnb(s + " ");
        }
        print();

        for (String s : mic.reversed()) {
            printnb(s + " ");
        }
        print();

        for (String s : mic.randomize()) {
            printnb(s + " ");
        }
        print();
    }
}

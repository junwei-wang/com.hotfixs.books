package com.hotfixs.thinkinginjava.generics;

import static com.hotfixs.thinkinginjava.common.Print.printnb;

import java.util.Iterator;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int count;

    public IterableFibonacci(int n) {
        count = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Integer next() {
                count--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)) {
            printnb(i + " ");
        }
    }
}

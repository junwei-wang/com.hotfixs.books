package com.hotfixs.thinkinginjava.generics;

import static com.hotfixs.thinkinginjava.common.Print.printnb;

import com.hotfixs.thinkinginjava.common.Generator;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;
    private int last;
    private int secondLast;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            last = secondLast = 1;
            return last;
        }

        int tmp = last;
        last = last + secondLast;
        secondLast = tmp;
        return last;
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            printnb(gen.next() + " ");
        }
    }
}

package com.hotfixs.thinkinginjava.operators;

import static com.hotfixs.thinkinginjava.common.Print.printnb;
import static com.hotfixs.thinkinginjava.common.Range.range;

/**
 * @author wang
 */
public class ForEachInt {
    public static void main(String[] args) {
        for (int i : range(10)) {
            printnb(i + " ");
        }
    }
}

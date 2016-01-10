package com.hotfixs.thinkinginjava.enumerated.roshambo;

import static com.hotfixs.thinkinginjava.common.Print.print;

import com.hotfixs.thinkinginjava.common.Enums;

/**
 * @author wangjunwei
 */
public class RoShamBo {
    public static <T extends Competitor<T>> void match(T a, T b) {
        print(a + " vs. " + b + ": " + a.compete(b));
    }

    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(rsbClass), Enums.random(rsbClass));
        }
    }
}

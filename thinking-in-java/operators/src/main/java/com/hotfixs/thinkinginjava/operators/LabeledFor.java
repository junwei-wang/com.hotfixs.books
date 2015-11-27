package com.hotfixs.thinkinginjava.operators;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */
public class LabeledFor {
    public static void main(String[] args) {
        int i = 0;
        outer:
        for (; true; ) {
            inner:
            for (; i < 10; i++) {
                print("i = " + i);

                if (i == 2) {
                    print("continue");
                    continue;
                }

                if (i == 3) {
                    print("break");
                    i++;
                    break;
                }

                if (i == 7) {
                    print("continue outer");
                    i++;
                    continue outer;
                }

                if (i == 8) {
                    print("break outer");
                    break outer;
                }

                for (int j = 0; j < i; j++) {
                    print("continue inner");
                    continue inner;
                }
            }
        }
    }
}

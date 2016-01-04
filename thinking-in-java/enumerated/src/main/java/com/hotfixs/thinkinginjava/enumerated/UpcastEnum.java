package com.hotfixs.thinkinginjava.enumerated;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.Arrays;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
enum Search {
    HIGHER, YON
}

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        print(Arrays.toString(vals));
        Enum e = Search.HIGHER;
        for (Enum en : e.getClass().getEnumConstants()) {
            print(en);
        }
    }
}

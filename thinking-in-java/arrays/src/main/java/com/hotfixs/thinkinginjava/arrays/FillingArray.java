package com.hotfixs.thinkinginjava.arrays;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.Arrays;

/**
 * @author wangjunwei
 */
public class FillingArray {
    public static void main(String[] args) {
        String[] strings = new String[10];
        Arrays.fill(strings, "a");
        print(Arrays.toString(strings));
    }
}

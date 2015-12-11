package com.hotfixs.thinkinginjava.strings;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ReplacingStringTokenizer {
    public static void main(String[] args) {
        String input = "But I'm not dead yet! I feel happy!";

        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreElements()) {
            printnb(st.nextElement() + " ");
        }
        print();

        print(Arrays.toString(input.split(" ")));

        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            printnb(scanner.next() + " ");
        }
    }

}

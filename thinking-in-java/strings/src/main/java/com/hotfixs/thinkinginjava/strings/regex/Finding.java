package com.hotfixs.thinkinginjava.strings.regex;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Finding {
    public static void main(String[] args) {
        Matcher m  = Pattern.compile("\\w+")
                .matcher("Evening is full of linnet;s wings");

        while (m.find()) {
            printnb(m.group() + " ");
        }
        print();

        int i = 0;
        while (m.find(i)) {
            printnb(m.group() + " ");
            i++;
        }
    }
}

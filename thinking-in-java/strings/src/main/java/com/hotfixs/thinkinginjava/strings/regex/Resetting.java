package com.hotfixs.thinkinginjava.strings.regex;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Resetting {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("[frb][aiu][gx]")
                .matcher("fix the rug with bags");
        while (m.find()) {
            printnb(m.group() + " ");
        }
        print();

        m.reset("fux the rig with rags");
        while (m.find()) {
            printnb(m.group() + " ");
        }
        print();
    }
}

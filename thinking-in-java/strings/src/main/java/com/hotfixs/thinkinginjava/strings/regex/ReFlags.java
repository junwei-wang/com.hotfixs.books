package com.hotfixs.thinkinginjava.strings.regex;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ReFlags {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expressions\n" +
                        "Regular expressions are in Java"
        );

        while (m.find()) {
            print(m.group());
        }

        // \u003f is ?
        Pattern p1 = Pattern.compile("a\u003f", Pattern.CANON_EQ);
        Matcher m1 = p.matcher("Java");
        while (m1.find()) {
            print(m1.group());
        }
    }
}

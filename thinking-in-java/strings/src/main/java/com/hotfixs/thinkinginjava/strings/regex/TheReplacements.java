package com.hotfixs.thinkinginjava.strings.regex;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

public class TheReplacements {
    public static void main(String[] args) {
        String s = "/*! Here's a block of text to use as input to\n"
                + "    the regular expression matcher. Note that we'll\n"
                + "    first extract the block of text by looking for\n"
                + "    the special delimiters, then process the\n"
                + "    extracted block. !*/";
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL)
                .matcher(s);
        if (mInput.find()) {
            s = mInput.group(1);
        }
        s = s.replaceAll(" {2,}", " ");
        s = s.replaceAll("(?m)^ +", "");
        print(s);
        print();

        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("[aeiou]").matcher(s);
        while (m.find()) {
            m.appendReplacement(sb, m.group().toUpperCase());
        }
        m.appendTail(sb);
        print(sb);
    }
}

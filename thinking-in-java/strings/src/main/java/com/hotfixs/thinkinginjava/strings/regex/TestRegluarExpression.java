package com.hotfixs.thinkinginjava.strings.regex;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class TestRegluarExpression {
    public static void main(String[] args) {
        String str = "abcabcabcdefabc";
        String[] regexs = {"abcabcabcdefabc", "abc", "abcabcabc", "(abc){2,}"};

        for (String regex : regexs) {
            print("Regular expression: " + regex);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                print("Match \"" + matcher.group() + "\" at positions "
                        + matcher.start() + " - " + (matcher.end() - 1));
            }
            print();
        }
    }
}

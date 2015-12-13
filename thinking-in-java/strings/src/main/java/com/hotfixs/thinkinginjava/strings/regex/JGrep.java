package com.hotfixs.thinkinginjava.strings.regex;

import static com.hotfixs.thinkinginjava.common.Print.print;

import com.hotfixs.thinkinginjava.common.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class JGrep {
    public static void main(String[] args) {
        if (args.length < 2) {
            print("java JGrep file regex");
            System.exit(1);
        }

        print("grep " + args[0] + " " + args[1]);
        print(args[1].equals("\\b[Ssct]\\w+"));

        Matcher m = Pattern.compile(args[1]).matcher("");
        int index = 0;
        for (String s : new TextFile(args[0])) {
            m.reset(s);
            while (m.find()) {
                print(index++ + ": " + m.group() + ": " + m.start());
            }
        }
    }
}

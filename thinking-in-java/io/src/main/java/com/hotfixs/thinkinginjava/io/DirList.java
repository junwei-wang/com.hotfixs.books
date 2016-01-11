package com.hotfixs.thinkinginjava.io;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author wangjunwei
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;

        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String item : list) {
            print(item + ".length: " + new File(item).length());
        }
    }
}


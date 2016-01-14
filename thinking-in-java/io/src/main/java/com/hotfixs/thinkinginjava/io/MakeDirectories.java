package com.hotfixs.thinkinginjava.io;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.io.File;

/**
 * @author wangjunwei
 */
public class MakeDirectories {
    private static void usage() {
        System.err.println(
                "Usage:MakeDirectories path1 ...\n" +
                        "\tCreates each path\n" +
                        "Usage:MakeDirectories -d path1 ...\n" +
                        "\tDeletes each path\n" +
                        "Usage:MakeDirectories -r path1 path2\n" +
                        "\tRenames from path1 to path2");
        System.exit(1);
    }

    private static void fileData(File f) {
        print("Absolute path: " + f.getAbsolutePath() +
                "\n Can read: " + f.canRead() +
                "\n Can write: " + f.canWrite() +
                "\n getName: " + f.getName() +
                "\n getParent: " + f.getParent() +
                "\n getPath: " + f.getPath() +
                "\n length: " + f.length() +
                "\n lastModified: " + f.lastModified());
        if (f.isFile()) {
            print("It's a file");
        } else if (f.isDirectory()) {
            print("It's a directory");
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            usage();
        }

        if (args[0].equals("-r")) {
            if (args.length != 3) {
                usage();
            }

            File old = new File(args[1]);
            File rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }
    }
}

package com.hotfixs.thinkinginjava.io;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.io.File;
import java.io.IOException;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class FileExample {
    public static void main(String[] args) throws IOException {
        print(new File("..").getAbsolutePath());
        print(new File("..").getCanonicalPath());
        print(new File("..").isAbsolute());
        print(new File("/..").isAbsolute());
        print(new File("/ect/passwd").isHidden());
        print(new File("/ect/passwd").canRead());
        print(new File("/ect/passwd").toURI());
        print(new File("/ect/passwd").toURI().toURL());
        print(new File("/ect/passwd").toPath());
    }
}

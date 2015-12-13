package com.hotfixs.thinkinginjava.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class TextFile extends ArrayList<String> {
    // read the file as a single string
    public static String read(String fileName) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String spiltor) {
        super(Arrays.asList(read(fileName).split("\n")));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    public TextFile(String filename) {
        this(filename, "\n");
    }
}

package com.hotfixs.thinkinginjava.strings;

import static com.hotfixs.thinkinginjava.common.Print.print;

import com.hotfixs.thinkinginjava.common.BinaryFile;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Hex {
    public static String format(byte[] data) {
        StringBuffer buffer = new StringBuffer();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0) {
                buffer.append(String.format("%05X: ", n));
            }
            buffer.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) {
                buffer.deleteCharAt(buffer.length() - 1);
                buffer.append("\n");
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        print(format(BinaryFile.read("pom.xml")));
    }

}

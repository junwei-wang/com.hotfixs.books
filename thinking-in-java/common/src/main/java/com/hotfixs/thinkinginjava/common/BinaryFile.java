package com.hotfixs.thinkinginjava.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class BinaryFile {
    public static byte[] read(File file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] data = new byte[bufferedInputStream.available()];
                bufferedInputStream.read(data);
                return data;
            } catch (IOException e) {
                throw new RuntimeException("read file error", e);
            } finally {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException("close file error", e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found", e);
        }
    }

    public static byte[] read(String fileName) {
        return read(new File(fileName).getAbsoluteFile());
    }
}

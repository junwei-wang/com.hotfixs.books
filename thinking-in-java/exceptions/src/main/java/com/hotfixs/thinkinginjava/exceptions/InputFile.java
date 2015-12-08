package com.hotfixs.thinkinginjava.exceptions;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class InputFile {
    private BufferedReader in;

    // Constructor
    public InputFile(String filename) throws FileNotFoundException {
        try {
            in = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            print("Cannot open " + filename);
            throw e;
        } catch (Exception e) {
            try {
                in.close();
            } catch (IOException e2) {
                print("in.close() unsuccessful");
            }
            throw e;
        } finally {
            // Don't close file here
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine failed()");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            print("dispose successfully.");
        } catch (IOException e) {
            throw new RuntimeException("in.close failed");
        }
    }
}

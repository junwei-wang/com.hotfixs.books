package com.hotfixs.thinkinginjava.exceptions;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new IOException();
                case 2:
                    throw new RuntimeException("where am I");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class SomeCheckedException extends Exception {
}

public class TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        wce.throwRuntimeException(3);

        for (int i = 0; i < 4; i++) {
            try {
                if (i < 3) {
                    wce.throwRuntimeException(i);
                } else {
                    throw new SomeCheckedException();
                }
            } catch (SomeCheckedException e) {
                print("SomeCheckedException: " + e);
            } catch (RuntimeException e) {
                try {
                    throw e.getCause();
                } catch (FileNotFoundException e2) {
                    print(e2);
                } catch (IOException e2) {
                    print(e2)
                } catch (Throwable throwable) {
                    print(throwable);
                }
            }
        }
    }
}

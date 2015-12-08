package com.hotfixs.thinkinginjava.exceptions;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "very important exception";
    }
}

class OrdinaryException extends Exception {
    @Override
    public String toString() {
        return "ordinary exception";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void g() throws OrdinaryException {
        throw new OrdinaryException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                lm.g();
            }
        } catch (Exception e) {
            print(e);
        }
    }
}

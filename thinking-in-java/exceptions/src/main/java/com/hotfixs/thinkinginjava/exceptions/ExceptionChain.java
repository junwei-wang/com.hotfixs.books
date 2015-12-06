package com.hotfixs.thinkinginjava.exceptions;

/**
 * @author wang
 */

class AnException extends Exception {
}

public class ExceptionChain {
    public static void f() throws AnException {
        Exception e = new NullPointerException();
        AnException anException = new AnException();
        anException.initCause(e);
        throw anException;
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (AnException e) {
            e.printStackTrace();
        }
    }
}

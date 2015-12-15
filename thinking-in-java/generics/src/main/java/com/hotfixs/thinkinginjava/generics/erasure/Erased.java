package com.hotfixs.thinkinginjava.generics.erasure;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Erased<T> {
    public void f(Object arg) {
        // Error:       if (arg instanceof T) {
        // Error:       T a = new T();
        // Error:       T[] b = new T[10];
        T[] array = (T[]) new Object[10];
    }
}

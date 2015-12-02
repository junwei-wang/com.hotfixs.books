package com.hotfixs.thinkinginjava.interfaces.filter;

/**
 * @author wang
 */
public class Waveform {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Waveform " + id;
    }
}

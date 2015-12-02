package com.hotfixs.thinkinginjava.interfaces.filter;

/**
 * @author wang
 */
public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform waveform) {
        return waveform;
    }
}

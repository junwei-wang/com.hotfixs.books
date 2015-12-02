package com.hotfixs.thinkinginjava.interfaces.filter;

/**
 * @author wang
 */
public class HighPass extends Filter {
    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform waveform) {
        return waveform; // Dummy process
    }
}

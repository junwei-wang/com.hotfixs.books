package com.hotfixs.thinkinginjava.interfaces.filter;

/**
 * @author wang
 */
public class LowPass extends Filter {
    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform waveform) {
        return waveform; // Dummy process
    }
}

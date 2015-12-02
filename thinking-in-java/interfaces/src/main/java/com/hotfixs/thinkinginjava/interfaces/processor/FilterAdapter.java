package com.hotfixs.thinkinginjava.interfaces.processor;

import com.hotfixs.thinkinginjava.interfaces.filter.Filter;
import com.hotfixs.thinkinginjava.interfaces.filter.HighPass;
import com.hotfixs.thinkinginjava.interfaces.filter.LowPass;
import com.hotfixs.thinkinginjava.interfaces.filter.Waveform;

/**
 * 适配器模式
 *
 * @author wang
 */
public class FilterAdapter implements Processor {
    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }

    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
    }
}

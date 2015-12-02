package com.hotfixs.thinkinginjava.interfaces.processor;

/**
 * @author wang
 */
public interface Processor {
    String name();

    Object process(Object input);
}

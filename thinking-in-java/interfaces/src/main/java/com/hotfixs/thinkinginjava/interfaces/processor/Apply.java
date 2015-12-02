package com.hotfixs.thinkinginjava.interfaces.processor;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */
public class Apply {
    public static void process(Processor processor, Object object) {
        print("Using Processor: " + processor.name());
        print(processor.process(object));
    }
}

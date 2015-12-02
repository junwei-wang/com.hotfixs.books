package com.hotfixs.thinkinginjava.interfaces.processor;

import java.util.Arrays;

/**
 * @author wang
 */
public abstract class StringProcessor implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    //    public abstract String process(Object object);
    public static String s = "Simple String";

    // 策略模式
    public static void main(String[] args) {
        Apply.process(new Uppercase(), s);
        Apply.process(new Downcase(), s);
        Apply.process(new Splitter(), s);
    }
}

class Uppercase extends StringProcessor {

    @Override
    public Object process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends StringProcessor {

    @Override
    public Object process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {

    @Override
    public Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

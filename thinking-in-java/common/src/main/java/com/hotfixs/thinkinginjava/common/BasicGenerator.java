package com.hotfixs.thinkinginjava.common;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    // produce a defual generator for a give clas type
    public static <T> BasicGenerator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

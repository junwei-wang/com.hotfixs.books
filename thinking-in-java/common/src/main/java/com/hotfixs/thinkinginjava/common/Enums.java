package com.hotfixs.thinkinginjava.common;

import java.util.Random;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Enums {
    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> clazz) {
        return random(clazz.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}

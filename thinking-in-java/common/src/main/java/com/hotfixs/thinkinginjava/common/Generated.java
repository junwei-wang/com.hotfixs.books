package com.hotfixs.thinkinginjava.common;

import java.lang.reflect.Array;

/**
 * @author wangjunwei
 */
public class Generated {
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<>(gen, a.length).toArray(a);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int quality) {
        T[] array = (T[]) Array.newInstance(type, quality);
        return new CollectionData<>(gen, quality).toArray(array);
    }
}

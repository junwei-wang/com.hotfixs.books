package com.hotfixs.thinkinginjava.common;

import java.util.ArrayList;

/**
 * @author wangjunwei
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quality) {
        for (int i = 0; i < quality; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quality) {
        return new CollectionData<>(gen, quality);
    }
}

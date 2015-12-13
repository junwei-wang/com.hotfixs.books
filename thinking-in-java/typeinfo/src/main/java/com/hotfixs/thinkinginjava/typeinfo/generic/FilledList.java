package com.hotfixs.thinkinginjava.typeinfo.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
class CountedInteger {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class FilledList<T> {
    // why not using T.class?
    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> results = new ArrayList<>();
        try {
            for (int i = 0; i < nElements; i++) {
                results.add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> list = new FilledList<>(CountedInteger.class);
        System.out.println(list.create(15));
    }
}

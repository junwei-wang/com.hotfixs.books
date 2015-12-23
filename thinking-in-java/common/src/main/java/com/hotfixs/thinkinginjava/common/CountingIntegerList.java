package com.hotfixs.thinkinginjava.common;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.AbstractList;

/**
 * Flyweight design pattern
 *
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class CountingIntegerList extends AbstractList<Integer> {
    private int size;

    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        print(new CountingIntegerList(10));
    }
}

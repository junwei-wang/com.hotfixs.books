package com.hotfixs.thinkinginjava.generics.pets;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Hamster extends Pet implements Comparable<Pet> {
    @Override
    public int compareTo(Pet arg) {
        return 0;
    }
}

package com.hotfixs.thinkinginjava.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author wang
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Integer[] moreInts = {5, 6, 7, 8, 9};
        collection.addAll(Arrays.asList(moreInts));

        // normally faster
        Collections.addAll(collection, moreInts);
        Collections.addAll(collection, 11, 12, 13, 14, 15);

        // return Arrays.ArrayList, whose size is fixed by the array
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);
        list.add(30);
    }
}

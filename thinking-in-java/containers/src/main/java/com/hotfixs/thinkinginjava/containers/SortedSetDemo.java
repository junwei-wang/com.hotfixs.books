package com.hotfixs.thinkinginjava.containers;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
        print(sortedSet);

        String low = sortedSet.first();
        String high = sortedSet.last();
        print(low);
        print(high);

        Iterator<String> iterator = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) {
                low = iterator.next();
            } else if (i == 7) {
                high = iterator.next();
            } else {
                iterator.next();
            }
        }
        print(low);
        print(high);

        print(sortedSet.subSet(low, high));
        print(sortedSet.headSet(low));
        print(sortedSet.headSet(high));
        print(sortedSet.tailSet(low));
        print(sortedSet.tailSet(high));
    }
}

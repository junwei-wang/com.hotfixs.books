package com.hotfixs.thinkinginjava.containers;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import com.hotfixs.thinkinginjava.common.CountingMapData;

import java.util.LinkedHashMap;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(
                new CountingMapData(9)
        );
        print(linkedMap);
        print();

        // Least-Recently-Used order (LRU)
        linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(9));
        print(linkedMap);
        print();

        for (int i = 0; i < 6; i++) {
            printnb(i + "," + linkedMap.get(i) + ": ");
            print(linkedMap);
        }
        print();

        linkedMap.get(0);
        print(linkedMap);
    }
}

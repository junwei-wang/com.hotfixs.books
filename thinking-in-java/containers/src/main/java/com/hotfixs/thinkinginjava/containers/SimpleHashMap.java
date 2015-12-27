package com.hotfixs.thinkinginjava.containers;

import static com.hotfixs.thinkinginjava.common.Print.print;

import com.hotfixs.thinkinginjava.common.Countries;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    // choose a prime number as the size of hash table, to achieve a uniform distribution.
    private static final int SIZE = 997;

    // we cannot have a physical generic array, but we can upcast to one.
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);

        boolean found = false;
        for (MapEntry<K, V> entry : bucket) {
            if (entry.getKey().equals(pair.getKey())) {
                oldValue = entry.getValue();
                entry.setValue(value);
                found = true;
                break;
            }
        }
        if (!found) {
            bucket.add(pair);
        }

        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        if (bucket == null) {
            return null;
        }

        for (MapEntry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }

            set.addAll(bucket);
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.putAll(Countries.capitals(15));
        print(map);
        print(map.get("BENIN"));
        print(map.entrySet());
    }
}

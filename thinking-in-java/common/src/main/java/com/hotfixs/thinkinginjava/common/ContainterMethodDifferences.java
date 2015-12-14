package com.hotfixs.thinkinginjava.common;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ContainterMethodDifferences {
    public static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<>();
        Method[] methods = type.getMethods();
        for (Method m : methods) {
            result.add(m.getName());
        }
        return result;
    }

    public static void interfaces(Class<?> type) {
        printnb("Interfaces in " + type.getSimpleName() + ": ");
        List<String> result = new ArrayList<>();
        for (Class<?> c : type.getInterfaces()) {
            result.add(c.getSimpleName());
        }
        print(result);
    }

    public static Set<String> object = methodSet(Object.class);

    static {
        object.add("clone");
    }

    public static void difference(Class<?> superset, Class<?> subset) {
        printnb(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds: ");
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);
        print(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        print("Collections: " + methodSet(Collection.class));
        interfaces(Collection.class);
        print();

        difference(Set.class, Collection.class);
        print();
        difference(HashSet.class, Set.class);
        print();
        difference(LinkedHashSet.class, HashSet.class);
        print();
        difference(TreeSet.class, Set.class);
        print();

        difference(List.class, Collection.class);
        print();
        difference(ArrayList.class, List.class);
        print();
        difference(LinkedList.class, List.class);
        print();

        difference(Queue.class, Collection.class);
        print();

        print("Map: " + methodSet(Map.class));
        interfaces(Map.class);
        print();
        difference(HashMap.class, Map.class);
        print();
        difference(LinkedHashMap.class, HashMap.class);
        print();
        difference(SortedMap.class, Map.class);
        print();
        difference(TreeMap.class, Map.class);
        print();
    }
}

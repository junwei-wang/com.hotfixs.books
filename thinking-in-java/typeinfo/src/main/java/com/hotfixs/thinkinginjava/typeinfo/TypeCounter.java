package com.hotfixs.thinkinginjava.typeinfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
    public Class<?> baseType;

    public TypeCounter(Class baseType) {
        this.baseType = baseType;
    }

    public void count(Object obj) {
        Class<?> type = obj.getClass();

        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(obj + " incorrect type: " + type + ", should be type of subtype of " + baseType);
        }

        countClass(type);
    }

    public void countClass(Class<?> type) {
        Integer quality = getOrDefault(type, 0);
        put(type, quality + 1);

        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("(");
        for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append(")");
        return result.toString();
    }
}

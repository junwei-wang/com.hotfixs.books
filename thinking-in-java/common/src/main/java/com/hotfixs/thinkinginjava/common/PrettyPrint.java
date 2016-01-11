package com.hotfixs.thinkinginjava.common;

import java.util.Collection;

/**
 * @author wangjunwei
 */
public class PrettyPrint {
    public static String pformat(Collection<?> c) {
        if (c.size() == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (Object o : c) {
            if (c.size() != 1) {
                sb.append("\n");
            }
            sb.append(o);
        }
        if (c.size() != 1) {
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}

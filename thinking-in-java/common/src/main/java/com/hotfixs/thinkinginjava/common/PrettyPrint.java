package com.hotfixs.thinkinginjava.common;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.Arrays;
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

    public static void pprint(Collection<?> c) {
        print(pformat(c));
    }

    public static void pprint(Object[] c) {
        print(pformat(Arrays.asList(c)));
    }
}

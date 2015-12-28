package com.hotfixs.thinkinginjava.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author wangjunwei
 */
public class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> it = c.iterator();
        c.add("a");
        while (it.hasNext()) {
            it.next();
        }
    }
}

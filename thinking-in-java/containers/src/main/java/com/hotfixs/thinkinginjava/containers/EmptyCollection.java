package com.hotfixs.thinkinginjava.containers;

import java.util.Collections;
import java.util.List;

/**
 * @author wangjunwei
 */
public class EmptyCollection {
    public static void main(String[] args) {
        List<String> list = Collections.emptyList();
        list.add("a");
    }
}

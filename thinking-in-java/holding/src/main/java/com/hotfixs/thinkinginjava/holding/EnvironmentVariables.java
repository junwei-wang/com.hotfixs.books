package com.hotfixs.thinkinginjava.holding;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.Map;

/**
 * @author wang
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            print(entry.getKey() + " " + entry.getValue());
        }
    }
}

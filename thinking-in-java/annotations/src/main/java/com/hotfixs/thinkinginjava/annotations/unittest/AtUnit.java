package com.hotfixs.thinkinginjava.annotations.unittest;

import java.io.File;

/**
 * @author wangjunwei
 */
public class AtUnit implements ProcessFiles.Strategy {
    static long testRun = 0;
    static long failures = 0;

    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);

        new ProcessFiles(new AtUnit(), "class").start(args);
        if (failures == 0) {
            System.out.println("OK (" + testRun + " tests)");
        } else {
            
        }
    }

    @Override
    public void process(File file) {

    }
}

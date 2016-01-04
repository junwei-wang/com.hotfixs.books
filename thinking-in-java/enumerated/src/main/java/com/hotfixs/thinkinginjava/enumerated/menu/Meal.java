package com.hotfixs.thinkinginjava.enumerated.menu;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                print(course.randomSelection());
            }
            print("-----");
        }
    }
}

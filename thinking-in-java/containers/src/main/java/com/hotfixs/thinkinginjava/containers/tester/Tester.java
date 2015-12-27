package com.hotfixs.thinkinginjava.containers.tester;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParam[] defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);

    protected C initialize(int size) {
        return container;
    }

    protected C container;
    private String headline = "";
    private List<Test<C>> tests;

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;

    private static String sizeField = "%" + sizeWidth + "s";

    private TestParam[] paramList = defaultParams;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null) {
            headline = container.getClass().getSimpleName();
        }
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    public void setHeadline(String newHeadline) {
        this.headline = newHeadline;
    }

    public static <C> void run(C container, List<Test<C>> tests) {
        new Tester<>(container, tests).timedTest();
    }

    public static <C> void run(C container, List<Test<C>> tests, TestParam[] paramList) {
        new Tester<>(container, tests, paramList).timedTest();
    }

    public void timedTest() {
        displayHeader();

        for (TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for (Test<C> test : tests) {
                C kontainer = initialize(param.size);
                long start = System.nanoTime();
                int reps = test.test(kontainer, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(), timePerRep);
            }
            print();
        }
    }

    private void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder head = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        print(head);
        // Print column headers:
        System.out.format(sizeField, "size");
        for (Test test : tests) {
            System.out.format(stringField(), test.name);
        }
        print();
    }

}

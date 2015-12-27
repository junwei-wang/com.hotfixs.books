package com.hotfixs.thinkinginjava.containers.tester;

import com.hotfixs.thinkinginjava.common.CountingGenerator;
import com.hotfixs.thinkinginjava.common.CountingIntegerList;
import com.hotfixs.thinkinginjava.common.Generated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ListPerformance {
    static Random random = new Random(47);
    static int reps = 1000;
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static List<Test<LinkedList<Integer>>> qTests = new ArrayList<>();

    static {
        // tests for list
        tests.add(new Test<List<Integer>>("add") {
            @Override
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++) {
                        list.add(j);
                    }
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            @Override
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.get(random.nextInt(listSize));
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("set") {
            @Override
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.set(random.nextInt(listSize), 47);
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("iteradd") {
            @Override
            int test(List<Integer> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = tp.size / 2;
                ListIterator<Integer> it = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++) {
                    it.add(47);
                }
                return LOOPS;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {
            @Override
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++) {
                    list.add(5, 47);
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove") {
            @Override
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(listSize));
                    while (list.size() > 5) {
                        list.remove(5);
                    }
                }
                return loops * listSize;
            }
        });

        // tests for queue
        qTests.add(new Test<LinkedList<Integer>>("addFirst") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++) {
                        list.addFirst(47);
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("addLast") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++) {
                        list.addLast(47);
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("rmFirst") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while (list.size() > 0) {
                        list.removeFirst();
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("rmLast") {
            int test(LinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while (list.size() > 0) {
                        list.removeLast();
                    }
                }
                return loops * size;
            }
        });
    }

    static class ListTester extends Tester<List<Integer>> {
        public ListTester(List<Integer> container,
                          List<Test<List<Integer>>> tests) {
            super(container, tests);
        }

        @Override
        protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }

        public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }

        Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null, tests.subList(1, 3)) {
            // This will be called before each test. It
            // produces a non-resizeable array-backed list:
            @Override
            protected List<Integer> initialize(int size) {
                Integer[] ia = Generated.array(Integer.class, new CountingGenerator.Integer(), size);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();

        Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        ListTester.run(new ArrayList<>(), tests);
        ListTester.run(new LinkedList<>(), tests);
        ListTester.run(new Vector<>(), tests);

        Tester.fieldWidth = 12;
        Tester<LinkedList<Integer>> qTest = new Tester<>(new LinkedList<>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }
}

package com.hotfixs.thinkinginjava.containers;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import com.hotfixs.thinkinginjava.common.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class QueueBehavior {
    private static int count = 10;

    static <T> void test(Queue<T> queue, Generator<T> gen) {
        for (int i = 0; i < count; i++) {
            queue.offer(gen.next());
        }

        while (queue.peek() != null) {
            printnb(queue.remove() + " ");
        }
        print();
    }

    static class Gen implements Generator<String> {
        String[] s = "one two three four five six seven eight nine ten".split(" ");
        int i = 0;

        @Override
        public String next() {
            return s[i++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<>(), new Gen());
        test(new PriorityQueue<>(), new Gen());
        test(new ArrayBlockingQueue<>(count), new Gen());
        test(new ConcurrentLinkedDeque<>(), new Gen());
        test(new LinkedBlockingDeque<>(), new Gen());
        test(new PriorityBlockingQueue<>(), new Gen());
    }
}

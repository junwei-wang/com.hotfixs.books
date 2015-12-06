package com.hotfixs.thinkinginjava.holding;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author wang
 */
public class QueueDemo {
    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            printnb(queue.remove() + " ");
        }
        print();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(100));
        }
        printQ(queue);
    }
}

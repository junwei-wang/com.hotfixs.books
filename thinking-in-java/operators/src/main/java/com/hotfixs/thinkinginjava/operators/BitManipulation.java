package com.hotfixs.thinkinginjava.operators; /**
 * @author wang
 */

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.Random;

public class BitManipulation {
    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt();
        printBinaryInt("         i", i);
        printBinaryInt("        ~i", ~i);
        printBinaryInt("        -i", ~i);
        printBinaryInt("    i >> 5", i >> 5);
        printBinaryInt("    i << 5", i << 5);
        printBinaryInt(" (~i) << 5", (~i) << 5);
        printBinaryInt("   i >>> 5", i >>> 5);
        printBinaryInt("(~i) >>> 5", (~i) >>> 5);

        long l = rand.nextLong();
        printBinaryLong("         l", l);
        printBinaryLong("        ~l", ~l);
        printBinaryLong("        -l", ~l);
        printBinaryLong("    l >> 5", l >> 5);
        printBinaryLong("    l << 5", l << 5);
        printBinaryLong(" (~l) << 5", (~l) << 5);
        printBinaryLong("   l >>> 5", l >>> 5);
        printBinaryLong("(~l) >>> 5", (~l) >>> 5);
    }

    static void printBinaryInt(String s, int i) {
        print(s + ",  int: " + i + ", binary:");
        print(Integer.toBinaryString(i) + ", length: " + Integer.toBinaryString(i).length());
    }

    static void printBinaryLong(String s, long l) {
        print(s + ", long: " + l + ", binary:");
        print(Long.toBinaryString(l) + ", length: " + Long.toBinaryString(l).length());
    }
}

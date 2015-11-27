package com.hotfixs.thinkinginjava.operators; /**
 * @author wang
 */

import static com.hotfixs.thinkinginjava.common.Print.print;

public class URShift {
    public static void main(String[] args) {
        int i = -1;
        print(Integer.toBinaryString(i));
        print(Integer.toBinaryString(i >>> 10));
        int i2 = i >>> 0b10100011; // only use the last 5 bit, 0b11 = 3
        print(Integer.toBinaryString(i2));
        i >>>= 10;
        print(Integer.toBinaryString(i));
        print();

        long l = -1L;
        print(Long.toBinaryString(l));
        print(Long.toBinaryString(l >>> 10));
        long l2 = l >>> 0b10100011; // only use the last 6 bit, 0b100011 = 33
        print(Long.toBinaryString(l2));
        l >>>= 10;
        print(Long.toBinaryString(l));
        print();

        short s = -1;
        print(Integer.toBinaryString(s));
        print(Integer.toBinaryString(s >>> 10));
        s >>>= 10;
        print(Integer.toBinaryString(s)); // take care
        print();

        byte b = -1;
        print(Integer.toBinaryString(b));
        print(Integer.toBinaryString(b >>> 10));
        b >>>= 10;
        print(Integer.toBinaryString(b)); // take care
        print();
    }
}

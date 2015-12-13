package com.hotfixs.thinkinginjava.strings;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.Scanner;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class BetterRead {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(SimpleRead.input);
        print("What's your name");
        String name = stdin.nextLine();
        print(name);

        print("How old are you? what's your favorite double?");
        int age = stdin.nextInt();
        double favourite = stdin.nextDouble();
        System.out.format("Hi age %s.\n", age);
        System.out.format("His favourite double number is %f.\n", favourite);
    }
}

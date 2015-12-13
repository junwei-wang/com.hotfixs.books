package com.hotfixs.thinkinginjava.strings;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class SimpleRead {
    public static BufferedReader input = new BufferedReader(
            new StringReader("Sir Robin of Camelot\n22 1.61803")
    );

    public static void main(String[] args) {
        try {
            print("What's your name");
            String name = input.readLine();
            print(name);

            print("How old are you? what's your favorite double?");
            String numbers = input.readLine();
            print(numbers);
            String[] numberArray = numbers.split(" ");

            int age = Integer.parseInt(numberArray[0]);
            double favourite = Double.parseDouble(numberArray[1]);
            System.out.format("Hi age %s.\n", age);
            System.out.format("His favourite double number is %f.\n", favourite);
        } catch (IOException e) {
            System.err.println("I/O exception");
        }
    }
}

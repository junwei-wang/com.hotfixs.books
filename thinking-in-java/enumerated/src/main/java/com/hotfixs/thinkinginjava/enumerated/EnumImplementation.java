package com.hotfixs.thinkinginjava.enumerated;

import static com.hotfixs.thinkinginjava.common.Print.print;

import com.hotfixs.thinkinginjava.common.Generator;

import java.util.Random;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
    A, B, C, D, E, F;
    private Random rand = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNext(Generator<T> gen) {
        print(gen.next());
    }

    public static void main(String[] args) {
        CartoonCharacter a = CartoonCharacter.A;
        for (int i = 0; i < 10; i++) {
            printNext(a);
        }
    }
}

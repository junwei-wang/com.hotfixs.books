package com.hotfixs.thinkinginjava.arrays;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class RaggedArray {

    public static void main(String[] args) {
        Random random = new Random(47);
        int[][][] a = new int[random.nextInt(7)][][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[random.nextInt(5)][];

            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = new int[random.nextInt(5)];
            }
        }

        print(Arrays.deepToString(a));
    }
}

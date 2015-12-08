package com.hotfixs.thinkinginjava.exceptions;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

class NeedCleanup {
    private static long counter = 1;
    private final long id = counter++;

    public void dispose() {
        print("NeedCleanup " + id + " disposed");
    }
}

class ConstructionException extends Exception {
}

class NeedCleanupSub extends NeedCleanup {
    public NeedCleanupSub() throws ConstructionException {
    }
}

public class CleanupIdiom {
    public static void main(String[] args) {
        // Section 1:
        NeedCleanup nc1 = new NeedCleanup();
        try {
            // ...
        } finally {
            nc1.dispose();
        }

        // Section 2:
        // If constructions cannot fail, we can group objects
        NeedCleanup nc2 = new NeedCleanup();
        NeedCleanup nc3 = new NeedCleanup();
        try {
            // ...
        } finally {
            nc3.dispose(); // reverse the order of construction
            nc2.dispose();
        }

        // Section 3:
        // If Construction can fail, we must guard each one
        try {
            NeedCleanupSub nc4 = new NeedCleanupSub();
            try {
                NeedCleanupSub nc5 = new NeedCleanupSub();
                try {
                    // ...
                } finally {
                    nc5.dispose();
                }
            } catch (ConstructionException e) {
                print(e);
            } finally {
                nc4.dispose();
            }
        } catch (ConstructionException e) {
            print(e);
        }
    }
}

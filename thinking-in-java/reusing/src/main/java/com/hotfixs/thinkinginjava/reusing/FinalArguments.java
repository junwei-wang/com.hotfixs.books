package com.hotfixs.thinkinginjava.reusing;

/**
 * @author wang
 */
public class FinalArguments {
    void with(final Gizmo g) {
        // ! g = new Gizmo();
        g.value = 1;
    }

    void withOut(Gizmo g) {
        g = new Gizmo();
    }

    //    int f(final int i) {
    //        return i++;
    //    }

    int g(final int i) {
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.withOut(null);

        Gizmo g = new Gizmo();
        bf.with(g);
    }
}

class Gizmo {
    int value;

    public void spin() {
    }
}

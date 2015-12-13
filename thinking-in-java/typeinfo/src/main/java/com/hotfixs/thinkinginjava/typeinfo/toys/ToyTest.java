package com.hotfixs.thinkinginjava.typeinfo.toys;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
interface HasBatteries {
}

interface Waterproof {
}

interface Shoes {
}

class Toy {
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoes {
    FancyToy(int i) {
        super(i);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        print("====");
        print("Class name: " + cc.getName() + " is interface? " + cc.isInterface());
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.hotfixs.thinkinginjava.typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Cannot find FancyToy");
            System.exit(1);
        }
        printInfo(c);

        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;

        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }

}

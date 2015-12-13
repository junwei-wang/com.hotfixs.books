package com.hotfixs.thinkinginjava.typeinfo;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
class Candy {
    static {
        print("init candy");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        try {
            print("Before");
            Class c = Class.forName("com.hotfixs.thinkinginjava.typeinfo.Candy");
            print("After");

            // is Class single instance??
            Candy candy = new Candy();
            print(c == candy.getClass());
            print(c.equals(candy.getClass()));
            print(c == Candy.class);
            print(c.equals(Candy.class));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

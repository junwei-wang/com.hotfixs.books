package com.hotfixs.thinkinginjava.innerclasses;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */
public class Parcel9 {
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            {
                print("Inside instance initialize.");
            }

            @Override
            public String readLabel() {
                return this.label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        p.destination("abc");
    }
}

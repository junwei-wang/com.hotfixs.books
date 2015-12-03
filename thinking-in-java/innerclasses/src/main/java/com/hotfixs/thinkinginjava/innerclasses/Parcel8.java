package com.hotfixs.thinkinginjava.innerclasses;

/**
 * @author wang
 */
public class Parcel8 {
    public Wrapping wrapping(int x) {
        return new Wrapping(x) {
            @Override
            public int value() {
                return super.value() * 47;
            }
        };
    }
}

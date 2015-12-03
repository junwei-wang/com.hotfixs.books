package com.hotfixs.thinkinginjava.innerclasses;

/**
 * @author wang
 */
public class Parcel7 {
    public Content contents() {
        return new Content() {
            @Override
            public int value() {
                return 0;
            }
        };
    }
}

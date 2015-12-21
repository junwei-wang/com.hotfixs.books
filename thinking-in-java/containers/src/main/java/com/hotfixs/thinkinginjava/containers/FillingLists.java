package com.hotfixs.thinkinginjava.containers;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */

class Address {
    private String addr;

    public Address(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return super.toString() + " " + addr;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        ArrayList<Address> list = new ArrayList<>(Collections.nCopies(3, new Address("world")));
        print(list);

        Collections.fill(list, new Address("hello"));
        print(list);

    }

}

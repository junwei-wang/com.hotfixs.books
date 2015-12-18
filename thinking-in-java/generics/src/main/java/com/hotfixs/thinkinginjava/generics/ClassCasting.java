package com.hotfixs.thinkinginjava.generics;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ClassCasting {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> strings = Arrays.asList("a b c".split(" "));
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(args[0]));
        out.writeObject(strings);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        List<String> strings1 = List.class.cast(in.readObject());
        in.close();
        // illegal: List<String> strings2 = List<String>.class.cast(in.readObject());

        for (String s : strings1) {
            print(s);
        }
    }
}

package com.hotfixs.thinkinginjava.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class ForNameCreator extends PetCreator {
    public static final List<Class<? extends Pet>> allTypes = new ArrayList<>();

    private static String[] typeNames = {
            "com.hotfixs.thinkinginjava.typeinfo.pets.Mutt",
            "com.hotfixs.thinkinginjava.typeinfo.pets.Pug",
            "com.hotfixs.thinkinginjava.typeinfo.pets.EgyptianMau",
            "com.hotfixs.thinkinginjava.typeinfo.pets.Manx",
            "com.hotfixs.thinkinginjava.typeinfo.pets.Cymric",
            "com.hotfixs.thinkinginjava.typeinfo.pets.Rat",
            "com.hotfixs.thinkinginjava.typeinfo.pets.Mouse",
            "com.hotfixs.thinkinginjava.typeinfo.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        for (String name : typeNames) {
            try {
                allTypes.add((Class<? extends Pet>) Class.forName(name));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> type() {
        return allTypes;
    }
}

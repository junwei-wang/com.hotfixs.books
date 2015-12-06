package com.hotfixs.thinkinginjava.typeinfo.pets;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wang
 */
public class LiteralPetCreator extends PetCreator {
    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(
                    Arrays.asList(
                            Pet.class, Dog.class, Cat.class, Rodent.class,
                            Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
                            Cymric.class, Rat.class, Mouse.class, Hamster.class
                    )
            );
    private static final List<Class<? extends Pet>> types = allTypes.subList(
            allTypes.indexOf(Mutt.class), allTypes.size());

    @Override
    public List<Class<? extends Pet>> type() {
        return types;
    }

    public static void main(String[] args) {
        print(types);
    }
}

package com.hotfixs.thinkinginjava.typeinfo;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import com.hotfixs.thinkinginjava.typeinfo.pets.Pet;
import com.hotfixs.thinkinginjava.typeinfo.pets.Pets;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            printnb(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }

        print();
        print(counter);
    }
}

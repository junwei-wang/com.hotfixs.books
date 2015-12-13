package com.hotfixs.thinkinginjava.typeinfo;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import com.hotfixs.thinkinginjava.typeinfo.pets.Cat;
import com.hotfixs.thinkinginjava.typeinfo.pets.Cymric;
import com.hotfixs.thinkinginjava.typeinfo.pets.Dog;
import com.hotfixs.thinkinginjava.typeinfo.pets.EgyptianMau;
import com.hotfixs.thinkinginjava.typeinfo.pets.ForNameCreator;
import com.hotfixs.thinkinginjava.typeinfo.pets.Hamster;
import com.hotfixs.thinkinginjava.typeinfo.pets.Manx;
import com.hotfixs.thinkinginjava.typeinfo.pets.Mouse;
import com.hotfixs.thinkinginjava.typeinfo.pets.Mutt;
import com.hotfixs.thinkinginjava.typeinfo.pets.Pet;
import com.hotfixs.thinkinginjava.typeinfo.pets.PetCreator;
import com.hotfixs.thinkinginjava.typeinfo.pets.Pug;
import com.hotfixs.thinkinginjava.typeinfo.pets.Rat;
import com.hotfixs.thinkinginjava.typeinfo.pets.Rodent;

import java.util.HashMap;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            printnb(pet.getClass().getSimpleName() + " ");

            counter.count("Pet");
            if (pet instanceof Dog) {
                counter.count("Dog");
            }
            if (pet instanceof Mutt) {
                counter.count("Mutt");
            }
            if (pet instanceof Pug) {
                counter.count("Pug");
            }
            if (pet instanceof Cat) {
                counter.count("Cat");
            }
            if (pet instanceof EgyptianMau) {
                counter.count("EgyptianMau");
            }
            if (pet instanceof Manx) {
                counter.count("Manx");
            }
            if (pet instanceof Cymric) {
                counter.count("Cymric");
            }
            if (pet instanceof Rodent) {
                counter.count("Rodent");
            }
            if (pet instanceof Rat) {
                counter.count("Rat");
            }
            if (pet instanceof Mouse) {
                counter.count("Mouse");
            }
            if (pet instanceof Hamster) {
                counter.count("Hamster");
            }
        }
        print();
        print(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}

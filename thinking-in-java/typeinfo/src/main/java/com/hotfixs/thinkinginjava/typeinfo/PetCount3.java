package com.hotfixs.thinkinginjava.typeinfo;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import com.hotfixs.thinkinginjava.common.MapData;
import com.hotfixs.thinkinginjava.typeinfo.pets.LiteralPetCreator;
import com.hotfixs.thinkinginjava.typeinfo.pets.Pet;
import com.hotfixs.thinkinginjava.typeinfo.pets.Pets;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes, 0));
        }

        public void count(Pet pet) {
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                if (pair.getKey().isInstance(pet)) {
                    put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("(");
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }
            result.delete(result.length() - 2, result.length());
            result.append(")");
            return result.toString();
        }
    }


    public static void main(String[] args) {
        PetCounter counter = new PetCounter();
        for (Pet pet : Pets.createArray(20)) {
            printnb(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        print();
        print(counter);
    }
}

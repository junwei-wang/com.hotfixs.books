package com.hotfixs.thinkinginjava.typeinfo.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author wang
 */
public abstract class PetCreator {
    private Random random = new Random(47);

    public abstract List<Class<? extends Pet>> type();

    public Pet randomPet() {
        int n = random.nextInt(type().size());
        try {
            return type().get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException();
        }
    }

    public Pet[] createArray(int n) {
        Pet[] pets = new Pet[n];
        for (int i = 0; i < n; i++) {
            pets[i] = randomPet();
        }

        return pets;
    }

    public ArrayList<Pet> arrayList(int n) {
        ArrayList<Pet> pets = new ArrayList<>();
        Collections.addAll(pets, createArray(n));
        return pets;
    }
}

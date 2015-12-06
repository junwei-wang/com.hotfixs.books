package com.hotfixs.thinkinginjava.holding;

import static com.hotfixs.thinkinginjava.common.Print.print;
import static com.hotfixs.thinkinginjava.common.Print.printnb;

import com.hotfixs.thinkinginjava.typeinfo.pets.Pet;
import com.hotfixs.thinkinginjava.typeinfo.pets.Pets;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * @author wang
 */
public class CollectionSequence extends AbstractCollection<Pet> {
    private Pet[] pets = Pets.createArray(8);

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public int size() {
        return pets.length;
    }

    public static void main(String[] args) {
        CollectionSequence cs = new CollectionSequence();
        for (Pet pet : cs) {
            printnb(pet + " ");
        }
        print();

        Iterator<Pet> iterator = cs.iterator();
        while (iterator.hasNext()) {
            printnb(iterator.next() + " ");
        }
        print();
    }
}

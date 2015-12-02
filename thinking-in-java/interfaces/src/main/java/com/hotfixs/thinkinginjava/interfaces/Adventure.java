package com.hotfixs.thinkinginjava.interfaces;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wang
 */
public class Adventure {
    public static void main(String[] main) {
        Hero hero = new Hero();
        hero.fight();
    }
}

interface CanFight {
    void fight();
}

abstract class ActionCharacter {
    abstract void fight();
}

class Hero extends ActionCharacter implements CanFight {

    @Override
    public void fight() {
        print("It's no problem to override methods with same signatures.");
    }
}

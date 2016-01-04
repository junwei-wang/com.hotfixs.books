package com.hotfixs.thinkinginjava.enumerated.menu;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.BURRITO;
        food = Food.Dessert.BLACK_FOREST_CAKE;
        food = Food.Coffee.BLACK_COFFEE;
    }
}

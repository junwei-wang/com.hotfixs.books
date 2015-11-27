package com.hotfixs.thinkinginjava.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangjunwei
 */
public class UserCaseTracker {
    public static void trackUserCases(List<Integer> useCases, Class<?> cl) {
        for (Method method : cl.getDeclaredMethods()) {
            UseCase uc = method.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Find user case: " + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }

        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUserCases(useCases, PasswordUtils.class);
    }
}

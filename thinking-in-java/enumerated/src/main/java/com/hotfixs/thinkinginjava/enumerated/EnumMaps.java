package com.hotfixs.thinkinginjava.enumerated;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
interface Command {
    void action();
}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, () -> print("Kitchen fire!"));
        em.put(AlarmPoints.BATHROOM, () -> print("Bathroom alarm!"));

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            print(e.getKey() + ": ");
            e.getValue().action();
        }

        try {
            em.get(AlarmPoints.UTILITY).action();
        } catch (Exception e) {
            print(e);
        }
    }
}

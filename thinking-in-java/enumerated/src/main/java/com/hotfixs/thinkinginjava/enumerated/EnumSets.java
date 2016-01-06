package com.hotfixs.thinkinginjava.enumerated;

import static com.hotfixs.thinkinginjava.common.Print.print;

import java.util.EnumSet;

/**
 * @author Junwei Wang (i.junwei.wang@gmail.com)
 */
public class EnumSets {

    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(AlarmPoints.BATHROOM);
        print(points);

        points.addAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        print(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        print(points);

        points.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
        print(points);

        print(EnumSet.complementOf(points));
    }
}

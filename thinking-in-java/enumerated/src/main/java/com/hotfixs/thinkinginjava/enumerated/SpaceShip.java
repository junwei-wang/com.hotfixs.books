package com.hotfixs.thinkinginjava.enumerated;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wangjunwei
 */
public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        return id.charAt(0) + id.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        for (SpaceShip s : values()) {
            print(s);
        }
    }
}

package com.hotfixs.thinkinginjava.enumerated;

import static com.hotfixs.thinkinginjava.common.Print.print;

/**
 * @author wangjunwei
 */
public enum OzWitch {
    // instances must be defined first before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy’s house"),
    SOUTH("Good by inference, but missing");

    private String description;

    // constructor must be package or private access
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            print(witch + ": " + witch.getDescription());
        }
    }
}

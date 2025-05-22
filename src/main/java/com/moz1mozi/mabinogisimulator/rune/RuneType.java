package com.moz1mozi.mabinogisimulator.rune;

import lombok.Getter;

@Getter
public enum RuneType {
    WEAPON("무기"),
    ARMOR("방어구"),
    ACCESSORY("장신구"),
    EMBLEM("엠블럼");

    private final String displayName;

    RuneType(String displayName) {
        this.displayName = displayName;
    }
}

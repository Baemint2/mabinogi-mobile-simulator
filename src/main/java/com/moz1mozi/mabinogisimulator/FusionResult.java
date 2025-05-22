package com.moz1mozi.mabinogisimulator;

import com.moz1mozi.mabinogisimulator.rune.RuneRarity;
import com.moz1mozi.mabinogisimulator.rune.RuneType;
import lombok.Getter;

/**
 * 합성 결과를 담는 클래스
 */
@Getter
public class FusionResult {
    private final boolean success;
    private final RuneType type;
    private final RuneRarity rarity;
    private final String runeName;

    public FusionResult(boolean success, RuneType type, RuneRarity rarity, String runeName) {
        this.success = success;
        this.type = type;
        this.rarity = rarity;
        this.runeName = runeName;
    }

    @Override
    public String toString() {
        if (success) {
            return "합성 성공! " + type.getDisplayName() + " " + rarity.getDisplayName() + " 룬 획득: " + runeName;
        } else {
            return "합성 실패... " + rarity.getDisplayName() + " 등급 합성에 실패했습니다.";
        }
    }
}
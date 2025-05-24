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
    private final boolean greatSuccess;
    private final RuneType type;
    private final boolean useCatalyst;
    private final RuneRarity rarity;
    private final String runeName;
    private final String secondRuneName;

    public FusionResult(boolean success, boolean greatSuccess, RuneType type, boolean useCatalyst, RuneRarity rarity, String runeName, String secondRuneName) {
        this.success = success;
        this.greatSuccess = greatSuccess;
        this.type = type;
        this.useCatalyst = useCatalyst;
        this.rarity = rarity;
        this.runeName = runeName;
        this.secondRuneName = secondRuneName;
    }

    @Override
    public String toString() {
        if (success) {
            if (greatSuccess && useCatalyst) {
                return "합성 대 성공!"  + type.getDisplayName() + " " + rarity.getDisplayName() + " 룬 획득: " + runeName + ", " + secondRuneName;
            }
            return "합성 성공! " + type.getDisplayName() + " " + rarity.getDisplayName() + " 룬 획득: " + runeName;

        } else {
            return rarity.getDisplayName() + " 등급 합성에 실패했습니다.";
        }
    }
}
package com.moz1mozi.mabinogisimulator.rune;

import lombok.Getter;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;

import java.util.List;
import java.util.Map;

@Getter
public enum RuneRarity {
    /* 0 1 2 3 4 5 6*/
    ADVANCED(1, "고급", 90), // 1 : 고급 90%
    RARE_I(2, "레어1", 85), // 2 : 레어1 85%
    RARE_II(3, "레어2", 50), // 3 : 레어2 50%
    ELITE(4, "엘리트", 40), // 4 : 엘리트 40%
    EPIC(5, "에픽", 10), // 5 : 에픽 10%
    LEGENDARY(6, "전설", 0); // 6 : 전설

    private final int level;
    private final String displayName;
    private final int successRate; // 강화확률

    RuneRarity(int level, String displayName, int successRate) {
        this.level = level;
        this.displayName = displayName;
        this.successRate = successRate;
    }

    public RuneRarity getNextRarity() {
        return switch (this) {
            case ADVANCED -> RARE_I;
            case RARE_I -> RARE_II;
            case RARE_II -> ELITE;
            case ELITE -> EPIC;
            case EPIC -> LEGENDARY;
            default -> this;
        };
    }

    // RuneRarity와 ButtonStyle 매핑
    public static final Map<RuneRarity, ButtonStyle> RARITY_STYLES = Map.of(
            RuneRarity.ADVANCED, ButtonStyle.SECONDARY,
            RuneRarity.RARE_I, ButtonStyle.PRIMARY,
            RuneRarity.RARE_II, ButtonStyle.PRIMARY,
            RuneRarity.ELITE, ButtonStyle.SUCCESS,
            RuneRarity.EPIC, ButtonStyle.DANGER
    );

    // 사용할 희귀도 목록 (순서 유지를 위해 List 사용)
    public static final List<RuneRarity> AVAILABLE_RARITIES = List.of(
            RuneRarity.ADVANCED,
            RuneRarity.RARE_I,
            RuneRarity.RARE_II,
            RuneRarity.ELITE,
            RuneRarity.EPIC
    );

}

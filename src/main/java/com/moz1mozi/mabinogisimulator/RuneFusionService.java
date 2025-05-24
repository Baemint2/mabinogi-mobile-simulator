package com.moz1mozi.mabinogisimulator;

import com.moz1mozi.mabinogisimulator.rune.RuneRarity;
import com.moz1mozi.mabinogisimulator.rune.RuneType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class RuneFusionService {
    private static final Random random = new Random();

    /**
     * 룬 합성을 시도합니다.
     * @param type 룬 타입
     * @param targetRarity 목표 희귀도 (합성 결과로 얻고자 하는 희귀도)
     * @return 합성 결과 객체
     */
    public FusionResult attemptFusion(RuneType type, RuneRarity targetRarity) {
        // 현재 등급보다 한 단계 높은 등급의 룬을 얻고자 하는 경우
        RuneRarity currentRarity = getPreviousRarity(targetRarity);

        // 성공 확률 계산 (각 희귀도마다 다름)
        int successRate = targetRarity.getSuccessRate();

        // 합성 성공 여부 결정
        boolean success = random.nextInt(100) < successRate;

        String resultRuneName = null;

        if (success) {
            // 합성 성공: 다음 등급의 랜덤 룬 선택
            log.info("type: {}, rarity: {}", type, currentRarity);
            resultRuneName = RuneSelector.getRandomRuneName(type, currentRarity);
        }

        return new FusionResult(success, type, currentRarity, resultRuneName);
    }

    /**
     * 이전 등급의 희귀도를 반환합니다.
     */
    private RuneRarity getPreviousRarity(RuneRarity rarity) {
        return switch (rarity) {
            case ADVANCED -> RuneRarity.RARE_I;
            case RARE_I -> RuneRarity.RARE_II;
            case RARE_II -> RuneRarity.ELITE;
            case ELITE -> RuneRarity.EPIC;
            case EPIC -> RuneRarity.LEGENDARY;
            default -> throw new IllegalStateException("Unexpected value: " + rarity);
        };
    }


}
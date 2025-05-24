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
    private static final int GREAT_SUCCESS_RATE = 10; // 대성공 확률 10%

    /**
     * 룬 합성을 시도합니다.
     * @param type 룬 타입
     * @param targetRarity 목표 희귀도 (합성 결과로 얻고자 하는 희귀도)
     * @return 합성 결과 객체
     */
    public FusionResult attemptFusion(RuneType type, RuneRarity targetRarity, boolean useCatalyst) {
        // 현재 등급보다 한 단계 높은 등급의 룬을 얻고자 하는 경우
        RuneRarity currentRarity = getPreviousRarity(targetRarity);

        // 성공 확률 계산 (각 희귀도마다 다름)
        int successRate = targetRarity.getSuccessRate();
        boolean greatSuccess = false;

        // 합성 성공 여부 결정
        boolean success = random.nextInt(100) < successRate;

        // 첫 번째 룬 이름 (성공 시에만 설정)
        String resultRuneName = null;
        // 대성공 시 두 번째 룬 이름
        String secondRuneName = null;

        if (success) {
            // 합성 성공: 다음 등급의 랜덤 룬 선택
            log.info("type: {}, rarity: {}", type, currentRarity);
            resultRuneName = RuneSelector.getRandomRuneName(type, currentRarity);

            // 대성공 시 동일 등급의 룬을 하나 더 제공
            log.info("useCatalyst: {}", useCatalyst);
            if (useCatalyst) {
                greatSuccess = random.nextInt(100) < GREAT_SUCCESS_RATE;
                if (greatSuccess) {
                    secondRuneName = RuneSelector.getRandomRuneName(type, currentRarity);
                    log.info("대성공! {} 등급 룬 2개 획득: {}, {}", targetRarity.getDisplayName(), resultRuneName, secondRuneName);
                }
            }

        }

        return new FusionResult(success, greatSuccess, type, useCatalyst, currentRarity, resultRuneName, secondRuneName);
    }

    /**
     * 룬 합성을 재시도합니다.
     * @param type 룬 타입
     * @param targetRarity 목표 희귀도 (합성 결과로 얻고자 하는 희귀도)
     * @return 합성 결과 객체
     */
    public FusionResult attemptFusionRetry(RuneType type, RuneRarity targetRarity, boolean useCatalyst) {
        // 현재 등급보다 한 단계 높은 등급의 룬을 얻고자 하는 경우
        RuneRarity currentRarity = getPreviousRarity(targetRarity);

        // 성공 확률 계산 (각 희귀도마다 다름)
        int successRate = targetRarity.getSuccessRate();
        boolean greatSuccess = false;

        // 합성 성공 여부 결정
        boolean success = random.nextInt(100) < successRate;

        // 첫 번째 룬 이름 (성공 시에만 설정)
        String resultRuneName = null;
        // 대성공 시 두 번째 룬 이름
        String secondRuneName = null;

        if (!success && useCatalyst) {
            log.info("첫 시도 실패, 촉매제로 재시도합니다.");
            success = random.nextInt(100) < successRate;

            // 재시도 성공 시 대성공 여부 결정 (10% 확률)
            if (success) {
                resultRuneName = RuneSelector.getRandomRuneName(type, currentRarity);
                log.info("resultRuneName: {}", resultRuneName);
                greatSuccess = random.nextInt(100) < GREAT_SUCCESS_RATE;
                if (greatSuccess) {
                    secondRuneName = RuneSelector.getRandomRuneName(type, currentRarity);
                    log.info("대성공! {} 등급 룬 2개 획득: {}, {}", targetRarity.getDisplayName(), resultRuneName, secondRuneName);
                }
            } else {
                log.info("재시도도 실패했습니다.");
            }
            return new FusionResult(success, greatSuccess, type, useCatalyst, currentRarity, resultRuneName, secondRuneName);
        }

        return new FusionResult(false, greatSuccess, type, useCatalyst, currentRarity, resultRuneName, secondRuneName);
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
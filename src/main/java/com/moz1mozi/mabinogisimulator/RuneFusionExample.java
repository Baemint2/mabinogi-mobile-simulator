package com.moz1mozi.mabinogisimulator;

import com.moz1mozi.mabinogisimulator.rune.RuneRarity;
import com.moz1mozi.mabinogisimulator.rune.RuneType;

import java.io.InputStreamReader;
import java.util.Scanner;

public class RuneFusionExample {
    public static void main(String[] args) {
        // 합성 서비스 생성
        RuneFusionService fusionService = new RuneFusionService();

        System.out.println("강화할 타입을 입력해주세요");
        System.out.println("1: 무기, 2: 방어구, 3: 장신구, 4: 엠블렘: ");
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String string = scanner.nextLine();
        RuneType runeType = getRuneType(string);
        System.out.println("1: 고급, 2: 레어, 3: 레어, 4: 엘리트, 5: 에픽");
        System.out.print("강화할 아이템의 희귀도를 입력해주세요: ");
        scanner = new Scanner(new InputStreamReader(System.in));
        string = scanner.nextLine();
        RuneRarity rarity = getRarity(string);


        // 무기 룬 레어 등급 합성 시도
        FusionResult result = fusionService.attemptFusion(runeType, rarity);
        System.out.println(result);

        // 성공했다면 얻은 룬 정보 출력
        if (result.isSuccess()) {
            System.out.println("획득한 룬: " + result.getRuneName());
            System.out.println("희귀도: " + result.getRarity().getDisplayName());
        }
    }

    private static RuneRarity getRarity(String string) {
        return switch (string) {
            case "1" -> RuneRarity.ADVANCED;
            case "2" -> RuneRarity.RARE_I;
            case "3" -> RuneRarity.RARE_II;
            case "4" -> RuneRarity.ELITE;
            case "5" -> RuneRarity.EPIC;
            default -> throw new IllegalStateException("Unexpected value: " + string);
        };
    }

    private static RuneType getRuneType(String string) {
        return switch (string) {
            case "1" -> RuneType.WEAPON;
            case "2" -> RuneType.ARMOR;
            case "3" -> RuneType.ACCESSORY;
            case "4" -> RuneType.EMBLEM;
            default -> throw new IllegalStateException("Unexpected value: " + string);
        }
        ;
    }
}
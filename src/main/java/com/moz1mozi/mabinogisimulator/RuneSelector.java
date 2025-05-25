package com.moz1mozi.mabinogisimulator;

import com.moz1mozi.mabinogisimulator.constant.Accessory;
import com.moz1mozi.mabinogisimulator.constant.Armor;
import com.moz1mozi.mabinogisimulator.constant.Emblem;
import com.moz1mozi.mabinogisimulator.constant.Weapon;
import com.moz1mozi.mabinogisimulator.rune.RuneRarity;
import com.moz1mozi.mabinogisimulator.rune.RuneType;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuneSelector {
    private RuneSelector() {}

    public static final Random random = new Random();

    /**
     * 특정 타입과 희귀도에 해당하는 랜덤 룬 이름을 반환합니다.
     */
    public static String getRandomRuneName(RuneType type, RuneRarity rarity) {
        List<String> runeNames = getRuneNames(type, rarity);
        if (runeNames.isEmpty()) {
            throw new IllegalArgumentException("해당 타입과 희귀도의 룬이 존재하지 않습니다: " + type + ", " + rarity);
        }

        int randomIndex = random.nextInt(runeNames.size());
        return runeNames.get(randomIndex);
    }
    /**
     * 특정 타입과 희귀도에 해당하는 모든 룬 이름 목록을 반환합니다.
     */
    public static List<String> getRuneNames(RuneType type, RuneRarity rarity) {
        Class<?> runeClass = getRuneClass(type, rarity);
        List<String> runeNames = new ArrayList<>();

        try {
            for (Field field : runeClass.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) &&
                        Modifier.isFinal(field.getModifiers()) &&
                        field.getType() == String.class) {

                    String runeName = (String) field.get(null);
                    runeNames.add(runeName);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("룬 이름 가져오기 오류", e);
        }

        return runeNames;
    }

    /**
     * 타입과 희귀도에 해당하는 룬 클래스를 반환합니다.
     */
    private static Class<?> getRuneClass(RuneType type, RuneRarity rarity) {
        return switch (type) {
            case WEAPON -> switch (rarity) {
                case ADVANCED -> Weapon.Advanced.class;
                case RARE_I, RARE_II -> Weapon.Rare.class;
                case ELITE -> Weapon.Elite.class;
                case EPIC -> Weapon.Epic.class;
                case LEGENDARY -> Weapon.Legendary.class;
            };
            case ARMOR -> switch (rarity) {
                case ADVANCED -> Armor.Advanced.class;
                case RARE_I, RARE_II -> Armor.Rare.class;
                case ELITE -> Armor.Elite.class;
                case EPIC -> Armor.Epic.class;
                case LEGENDARY -> Armor.Legendary.class;
            };
            case ACCESSORY -> switch (rarity) {
                case ADVANCED -> Accessory.Advanced.class;
                case RARE_I, RARE_II -> Accessory.Rare.class;
                case ELITE -> Accessory.Elite.class;
                case EPIC -> Accessory.Epic.class;
                case LEGENDARY -> Accessory.Legendary.class;
            };
            case EMBLEM -> switch (rarity) {
                case ADVANCED -> Emblem.Advanced.class;
                case RARE_I, RARE_II -> Emblem.Rare.class;
                case ELITE -> Emblem.Elite.class;
                case EPIC -> Emblem.Epic.class;
                case LEGENDARY -> Emblem.Legendary.class;
            };
        };

    }
}


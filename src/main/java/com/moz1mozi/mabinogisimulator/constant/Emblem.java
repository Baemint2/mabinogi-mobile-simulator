package com.moz1mozi.mabinogisimulator.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 마비노기 시뮬레이터 엠블럼 룬 상수 클래스
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Emblem {

    /**
     * 고급 (Advanced) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Advanced {
        public static final String SWIFT = "쾌속";
        public static final String STAMINA = "체력";
        public static final String GRACE = "거셈";
        public static final String LIGHTNESS = "가벼움";
    }

    /**
     * 레어 (Rare) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Rare {
        public static final String FEROCITY = "사나움";
        public static final String ROUGHNESS = "거침";
        public static final String KINDNESS = "친절함";
        public static final String AGILITY = "민첩함";
        public static final String STRENGTH = "강함";
        public static final String CRUELTY = "잔인함";
        public static final String TOUGHNESS = "단단함";
    }

    /**
     * 엘리트 (Elite) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Elite {
        public static final String AGILITY = "기민함";
        public static final String POWER = "강력함";
        public static final String FEROCITY = "난폭함";
        public static final String STRENGTH = "강인함";
    }

    /**
     * 에픽 (Epic) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Epic {
        public static final String SWIFTNESS = "날쌤";
        public static final String INTENSITY = "강렬함";
        public static final String FEROCITY = "광폭함";
        public static final String TENACITY = "굳건함";
    }

    /**
     * 전설 (Legendary) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Legendary {
        public static final String ENHANCED_TENACITY = "굳건함+";
        public static final String ENHANCED_SWIFTNESS = "날쌤+";
        public static final String ENHANCED_INTENSITY = "강렬함+";
        public static final String ENHANCED_FEROCITY = "광폭함+";
        public static final String BRILLIANCE = "현란함";
        public static final String WISDOM = "지혜로움";
        public static final String CRUELTY = "냉혹함";
        public static final String DIVINE_POWER = "여신의 권능";
        public static final String DIVINE_PROTECTION = "여신의 가호";
    }
}
package com.moz1mozi.mabinogisimulator.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 마비노기 시뮬레이터 무기 룬 상수 클래스
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Weapon {

    /**
     * 고급 (Advanced) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Advanced {
        public static final String DEADLY = "치명";
        public static final String ACCELERATION = "가속";
        public static final String IMPACT = "충격";
        public static final String OPPORTUNITY = "기회";
        public static final String QUICKNESS = "신속";
        public static final String TENACITY = "투지";
        public static final String TACTICS = "기교";
    }

    /**
     * 레어 (Rare) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Rare {
        public static final String WOLF = "늑대";
        public static final String CROW = "까마귀";
        public static final String SNAKE = "뱀";
        public static final String LEOPARD = "표범";
        public static final String BEAR = "곰";
        public static final String LION = "사자";
        public static final String OWL = "올빼미";
        public static final String FLAME = "불꽃";
        public static final String ELECTRICITY = "전기";
        public static final String POISON = "독";
        public static final String FROST = "빙결";
        public static final String ROCK = "바위";
    }

    /**
     * 엘리트 (Elite) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Elite {
        public static final String DISPERSAL = "확산";
        public static final String VENOM = "맹독";
        public static final String BLOODLINE = "선혈";
        public static final String CONSCIOUSNESS = "의식";
        public static final String IRON = "철";
        public static final String SCOURGE = "삭풍";
        public static final String CONFRONTATION = "대결";
        public static final String BATTLEFIELD = "전장";
    }

    /**
     * 에픽 (Epic) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Epic {
        public static final String THRILL = "전율";
        public static final String LETHALITY = "극독";
        public static final String STEEL = "강철";
        public static final String WONDER = "경이";
        public static final String WHIRLWIND = "질풍";
        public static final String DUEL = "결투";
        public static final String PLAGUE = "역병";
        public static final String CLASH = "격전";
        public static final String ULTIMATUM = "궁극";
        public static final String RAGE = "격노";
        public static final String JUDGMENT = "선고";
        public static final String ASSAULT = "연격";
        public static final String EXTREME_COLD = "혹한";
        public static final String AGONY = "고통";
        public static final String HEMORRHAGE = "적혈";
        public static final String FLAME = "화염";
    }

    /**
     * 전설 (Legendary) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Legendary {
        public static final String CRUEL_WINTER = "냉혹한 겨울";
        public static final String COUNTLESS_FERMENTATIONS = "무수한 담금질";
        public static final String LIVING_WILDFIRE = "살아있는 번갯불";
        public static final String THORN_VINES = "가시 덩굴";
        public static final String BURNING_EMBER = "타오르는 불씨";
        public static final String RISING_MIST = "차오르는 안개";
        public static final String RAGING_WIND = "몰아치는 바람";
        public static final String THOUSAND_FOLD_SWORD = "천 자루 검";
        public static final String ANCIENT_GLADIATOR = "옛 검투사";
        public static final String HARMONY = "조화";
        public static final String LIGHT_AND_SHADOW = "명암";
        public static final String SUFFERING = "고뇌";
        public static final String ENHANCED_DUEL = "결투+";
        public static final String ENHANCED_WHIRLWIND = "질풍+";
        public static final String ENHANCED_WONDER = "경이+";
        public static final String ENHANCED_CLASH = "격전+";
        public static final String ENHANCED_PLAGUE = "역병+";
        public static final String ENHANCED_RAGE = "격노+";
        public static final String RUPTURE = "파열";
        public static final String BLIND_FURY = "눈 먼 분노";
        public static final String SOUL_HARVESTER = "영혼 수확자";
        public static final String FORGOTTEN_ERA = "잊힌 시대";
        public static final String MAGE_EXPLORER = "마법 탐구가";
        public static final String TWISTED_BLADE = "뒤틀린 칼날";
    }
}
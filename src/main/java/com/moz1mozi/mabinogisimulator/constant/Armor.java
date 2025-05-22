package com.moz1mozi.mabinogisimulator.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 마비노기 시뮬레이터 방어구 룬 상수 클래스
 */
public final class Armor {

    private Armor() {
    }

    /**
     * 고급 (Advanced) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Advanced {
        public static final String DEFENSE = "방어";
        public static final String RECOVERY = "회복";
        public static final String EVASION = "회피";
        public static final String FORTITUDE = "철벽";
        public static final String REGENERATION = "재생";
        public static final String AGILITY = "민첩";
    }

    /**
     * 레어 (Rare) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Rare {
        public static final String PATIENCE = "인내";
        public static final String HEALING = "치유";
        public static final String INTUITION = "직감";
        public static final String MYSTERY = "신비";
        public static final String SAFETY = "안전";
        public static final String DETERMINATION = "결사";
        public static final String PREEMPTION = "선제";
        public static final String BARRIER = "방벽";
        public static final String RESISTANCE = "저항";
        public static final String PROTECTION = "보호";
        public static final String AIM = "조준";
        public static final String RECOIL = "반동";
        public static final String HUNGER = "허기";
        public static final String INDOMITABILITY = "불굴";
    }

    /**
     * 엘리트 (Elite) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Elite {
        public static final String RUSHING = "격류";
        public static final String PECULIARITY = "기묘";
        public static final String ASSURANCE = "안심";
        public static final String SURVIVAL = "사활";
        public static final String INITIATION = "시작";
        public static final String WALL = "장벽";
        public static final String VIGILANCE = "경계";
        public static final String DEFENSE = "수비";
        public static final String SHOOTING = "사격";
        public static final String RAMPAGE = "폭주";
        public static final String STARVATION = "굶주림";
        public static final String STRUGGLE = "투쟁";
        public static final String REHABILITATION = "재활";
        public static final String DETERIORATION = "악화";
        public static final String ABSORPTION = "흡수";
        public static final String OVERCOMING = "극복";
    }

    /**
     * 에픽 (Epic) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Epic {
        public static final String STORM = "폭풍";
        public static final String SUPERNATURAL = "초자연";
        public static final String STABILITY = "안정";
        public static final String INITIAL = "초기";
        public static final String CASTLE = "성채";
        public static final String PROTECTION = "방호";
        public static final String SNIPE = "저격";
        public static final String OUTBREAK = "발진";
        public static final String DEFICIENCY = "결핍";
        public static final String MELEE = "난투";
        public static final String LIFE = "생명";
        public static final String WEAKNESS = "쇠약";
        public static final String FREEZING = "얼어붙음";
        public static final String BLOODSUCKING = "흡혈";
        public static final String AGONY = "격통";
        public static final String SACRIFICE = "제물";
        public static final String EROSION = "침식";
        public static final String PERSEVERANCE = "끈기";
        public static final String OVERWHELMING = "압도";
        public static final String DESPAIR = "절망";
        public static final String THREAT = "위협";
        public static final String TACTICIAN = "전술가";
        public static final String AMBUSH = "기습";
    }

    /**
     * 전설 (Legendary) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Legendary {
        public static final String FROZEN_FLAMES = "얼어붙은 불꽃";
        public static final String BLADE_BASTION = "칼날 보루";
        public static final String CONDENSED_MAGIC = "응축된 마력";
        public static final String SILENT_WIND = "고요한 바람";
        public static final String HOLY_LAMB = "신셩한 수양";
        public static final String THRILLING_BALLAD = "전율하는 악상";
        public static final String RUTHLESS_GAMBLER = "비정한 승부사";
        public static final String FIERCE_DOWNPOUR = "거센 소나기";
        public static final String CRIMSON_PLEDGE = "붉은 맹약";
        public static final String BLACK_VOW = "검은 서약";
        public static final String SURVIVAL_INSTINCT = "생존 본능";
        public static final String ENDLESS_VITALITY = "끝없는 활력";
        public static final String ELEMENTAL_SORCERER = "원소술사";
        public static final String EXTREME_NIGHT = "극야";
        public static final String ENLIGHTENMENT = "깨달음";
        public static final String TORCH = "횃불";
        public static final String SHATTER = "쇄빙";
        public static final String COUNTERACTION = "반작용";
        public static final String ENHANCED_STORM = "폭풍+";
        public static final String ENHANCED_BLOODSUCKING = "흡혈+";
        public static final String ENHANCED_SACRIFICE = "제물+";
        public static final String ENHANCED_EROSION = "침식+";
        public static final String ENHANCED_FREEZING = "얼어붙음+";
        public static final String ENHANCED_AGONY = "격통+";
        public static final String ENHANCED_WEAKNESS = "쇠약+";
        public static final String ENHANCED_STABILITY = "안정+";
        public static final String ENHANCED_SNIPE = "저격+";
        public static final String ENHANCED_PROTECTION = "방호+";
        public static final String ENHANCED_INITIAL = "초기+";
        public static final String ENHANCED_SUPERNATURAL = "초자연+";
        public static final String ENHANCED_LIFE = "생명+";
        public static final String ENHANCED_CASTLE = "성채+";
        public static final String ENHANCED_MELEE = "난투+";
        public static final String BLACK_FLAMES = "검은 불길";
        public static final String MANA_SURGE = "마나 격류";
        public static final String WINNING_STREAK = "연승";
        public static final String OVERCHARGE = "과충전";
        public static final String TOXIC_MIST = "독 안개";
        public static final String ROCK_GIANT = "바위 거인";
        public static final String VICIOUS_BLOW = "비열한 일격";
        public static final String POUNCING_SHADOW = "엄습하는 그림자";
        public static final String ETERNAL_GROUND = "영구 동토";
        public static final String PLAINS_WANDERER = "평원 방랑자";
        public static final String BARREN_LAND = "메마른 땅";
        public static final String SILVERSHINE_SPIRE = "은빛 첨탑";
        public static final String FEROCIOUS_WILL = "흉포한 의지";
        public static final String STORM_CLOUD = "폭풍 구름";
        public static final String MERCENARY_KING = "용병 왕";
        public static final String WANDERING_KNIGHT = "방랑 기사";
        public static final String TORRENTIAL_FLAMES = "빗발치는 화염";
        public static final String BURNING_HEART = "타오르는 심장";
        public static final String GIANTS_ARM = "거인의 팔";
        public static final String STARVING_BLADE = "굶주린 칼날";
        public static final String MARK_OF_DOOM = "파멸의 낙인";
        public static final String RESONATING_CRYSTAL = "공명하는 수정";
    }
}
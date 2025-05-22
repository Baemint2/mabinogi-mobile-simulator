package com.moz1mozi.mabinogisimulator.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 마비노기 시뮬레이터 룬 상수 클래스
 * 직업별 룬 특성과 효과 정의
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Accessory {

    /**
     * 고급 (Advanced) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Advanced {

        public static final String EXPLORER = "탐험가";
        public static final String ADVENTURER = "모험가";
        public static final String WANDERER = "방랑자";
        public static final String PERSISTENCE = "지속";
        public static final String CONTINUITY = "연속";
        public static final String IMPACT = "타격";
        public static final String SWIFTNESS = "빠름";
    }

    /**
     * 레어 (Rare) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Rare {
        public static final String DESTRUCTION = "파괴";
        public static final String RAPID_FIRE = "속사";
        public static final String RADIATION = "방사";
        public static final String SUPPRESSION = "제압";
        public static final String AMBUSH = "암습";
        public static final String PREDICTION = "점괘";
        public static final String OUTBURST = "격분";
        public static final String RELIEF = "안도";
        public static final String MITIGATION = "경감";
    }

    /**
     * 엘리트 (Elite) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Elite {
        // 전사
        public static final String CHARGE = "참격";
        public static final String RUSH = "돌진";
        public static final String ROAR = "포효";
        public static final String DETERMINATION = "패기";

        // 검술사
        public static final String PRESSURE = "압박";
        public static final String FIGHT = "무희";
        public static final String FEROCITY = "맹렬";
        public static final String BLOOD_GALE = "피바람";

        // 대검
        public static final String ROTATION = "회전";
        public static final String ANGER = "분노";
        public static final String DETERMINATION_GS = "회심";
        public static final String CUT = "절단";

        // 궁수
        public static final String CHARGE_ARCHER = "몰아침";
        public static final String AGILITY = "날렵함";
        public static final String ESCAPE = "탈출";
        public static final String QUICK = "재빠름";

        // 석궁
        public static final String ELECTROCUTION = "감전";
        public static final String DISTURBANCE = "방해";
        public static final String CURRENT = "전류";
        public static final String REVERSAL = "반전";

        // 장궁
        public static final String CRUSH = "파쇄";
        public static final String TENACITY = "끈질김";
        public static final String COLLAPSE = "무너짐";
        public static final String INJURY = "내상";

        // 마법사
        public static final String THUNDER = "낙뢰";
        public static final String LANDSLIDE = "산사태";
        public static final String FLASHING = "깜빡임";
        public static final String AMPLIFICATION = "증폭";

        // 빙결
        public static final String ARCTIC_WIND = "북풍";
        public static final String FROST = "고드름";
        public static final String WINTER = "겨울";
        public static final String FRAGMENT = "파편";

        // 화염
        public static final String VOLCANO = "불기둥";
        public static final String FIREPOWER = "화력";
        public static final String ERUPTION = "분출";
        public static final String HEATWAVE = "열풍";

        // 힐러
        public static final String VOW = "서약";
        public static final String TREMOR = "고동침";
        public static final String ENCLOSURE = "감쌈";
        public static final String WAVE = "물결";

        // 사제
        public static final String BOND = "결속";
        public static final String CARTWHEEL = "수레바퀴";
        public static final String SACRIFICE = "희생";
        public static final String HOLY_WAR = "성전";

        // 수도사
        public static final String KARMA = "인과";
        public static final String PURIFICATION = "정화";
        public static final String RADIANCE = "광휘";
        public static final String CONSECRATION = "축성";

        // 음유시인
        public static final String ASSAULT = "급습";
        public static final String IMPROMPTU = "즉흥";
        public static final String DECEPTION = "기만";
        public static final String WIT = "재치";

        // 악사
        public static final String RESONANCE = "공명";
        public static final String AFFECTION = "박애";
        public static final String DOUBLE_NOTE = "이중주";
        public static final String PULSE = "속주";

        // 댄서
        public static final String PASSION = "정열";
        public static final String APPROACH = "다가옴";
        public static final String FRESHNESS = "산뜻함";
        public static final String CONCISENESS = "간결함";

        // 도적
        public static final String THROWING = "투척";
        public static final String SLYNESS = "교활함";
        public static final String INGENUITY = "치밀함";
        public static final String TOXICITY = "독성";

        // 격투가
        public static final String LEAP = "도약";
        public static final String AGILITY_FIGHTER = "순발력";
        public static final String PASSION_FIGHTER = "열혈";
        public static final String ADVANCE = "전진";
        public static final String COLLISION = "충돌";
        public static final String DEFEAT = "격파";

        // 듀블
        public static final String BURN = "열상";
        public static final String FULL_MOON = "보름달";
        public static final String EXPEDITIOUS = "속행";
        public static final String REINFORCEMENT = "강화";
        public static final String WHIRLWIND = "회오리";
        public static final String CHARGE_DUAL = "질주";
    }

    /**
     * 에픽 (Epic) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Epic {
        // 전사
        public static final String MIGHTY_STRIKE = "맹공";
        public static final String ASSAULT = "돌격";

        // 검술사
        public static final String PENETRATION = "관통";
        public static final String FALLING_FLOWERS = "낙화";

        // 대검
        public static final String COUNTERATTACK = "반격";
        public static final String RESILIENCE = "탄력";

        // 궁수
        public static final String FATAL = "치명적";
        public static final String EAGLE = "매";

        // 석궁
        public static final String GUNPOWDER = "화약";
        public static final String CHAIN = "연쇄";

        // 장궁
        public static final String ULTRASONIC = "초음파";
        public static final String CONCENTRATION = "집중";

        // 마법사
        public static final String METEOR = "운석";
        public static final String FROST_THORN = "서리가시";

        // 빙결
        public static final String ICE_SWORD = "빙검";
        public static final String AURORA = "오로라";

        // 화염
        public static final String EMBERS = "불씨";
        public static final String ASHES = "잿더미";

        // 힐러
        public static final String SUPPRESSION = "억압";
        public static final String GLARE = "빛무리";

        // 사제
        public static final String WINGS = "날개";
        public static final String RAY_OF_LIGHT = "빛줄기";

        // 수도사
        public static final String RETRIBUTION = "응보";
        public static final String FLAME_UP = "업화";

        // 음유시인
        public static final String MOCKERY = "조롱";
        public static final String HARMONY = "화음";

        // 악사
        public static final String MENACE = "흉성";
        public static final String FINALE = "종장";

        // 댄서
        public static final String BUTTERFLY = "나비";
        public static final String SWING = "갈채";

        // 도적
        public static final String TOXIC_DANCE = "독무";
        public static final String GROUND_SPIDER = "땅거미";

        // 격투가
        public static final String COLLISION = "충돌";
        public static final String DEFEAT = "격파";

        // 듀블
        public static final String WHIRL = "회오리";
        public static final String SPRINT = "질주";
    }

    /**
     * 전설 (Legendary) 룬 상수
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Legendary {
        // 전사
        public static final String CHARGE_PLUS = "참격+";
        public static final String RUSH_PLUS = "돌진+";
        public static final String ROAR_PLUS = "포효+";
        public static final String DETERMINATION_PLUS = "패기+";
        public static final String MIGHTY_STRIKE_PLUS = "맹공+";
        public static final String WARRIOR_ASSAULT_PLUS = "돌격+";

        // 검술사
        public static final String PENETRATION_PLUS = "관통+";
        public static final String FALLING_FLOWERS_PLUS = "낙화+";
        public static final String BLOOD_GALE_PLUS = "피바람+";
        public static final String PRESSURE_PLUS = "압박+";
        public static final String FIGHT_PLUS = "무희+";
        public static final String FEROCITY_PLUS = "맹렬+";

        // 대검
        public static final String ROTATION_PLUS = "회전+";
        public static final String ANGER_PLUS = "분노+";
        public static final String DETERMINATION_GS_PLUS = "회심+";
        public static final String CUT_PLUS = "절단+";
        public static final String COUNTERATTACK_PLUS = "반격+";
        public static final String RESILIENCE_PLUS = "탄력+";

        // 궁수
        public static final String CHARGE_ARCHER_PLUS = "몰아침+";
        public static final String AGILITY_PLUS = "날렵함+";
        public static final String ESCAPE_PLUS = "탈출+";
        public static final String QUICK_PLUS = "재빠른+";
        public static final String FATAL_PLUS = "치명적+";
        public static final String EAGLE_PLUS = "매+";

        // 석궁
        public static final String ELECTROCUTION_PLUS = "감전+";
        public static final String DISTURBANCE_PLUS = "방해+";
        public static final String CURRENT_PLUS = "전류+";
        public static final String REVERSAL_PLUS = "반전+";
        public static final String GUNPOWDER_PLUS = "화약+";
        public static final String CHAIN_PLUS = "연쇄+";

        // 장궁
        public static final String CRUSH_PLUS = "파쇄+";
        public static final String TENACITY_PLUS = "끈질김+";
        public static final String COLLAPSE_PLUS = "무너짐+";
        public static final String INJURY_PLUS = "내상+";
        public static final String ULTRASONIC_PLUS = "초음파+";
        public static final String CONCENTRATION_PLUS = "집중+";

        // 마법사
        public static final String THUNDER_PLUS = "낙뢰+";
        public static final String LANDSLIDE_PLUS = "산사태+";
        public static final String FLASHING_PLUS = "깜빡임+";
        public static final String AMPLIFICATION_PLUS = "증폭+";
        public static final String METEOR_PLUS = "운석+";
        public static final String FROST_THORN_PLUS = "서리가시+";

        // 빙결
        public static final String ARCTIC_WIND_PLUS = "북풍+";
        public static final String FROST_PLUS = "고드름+";
        public static final String WINTER_PLUS = "겨울+";
        public static final String FRAGMENT_PLUS = "파편+";
        public static final String ICE_SWORD_PLUS = "빙검+";
        public static final String AURORA_PLUS = "오로라+";

        // 화염
        public static final String VOLCANO_PLUS = "불기둥+";
        public static final String FIREPOWER_PLUS = "화력+";
        public static final String ERUPTION_PLUS = "분출+";
        public static final String HEATWAVE_PLUS = "열풍+";
        public static final String EMBERS_PLUS = "불씨+";
        public static final String ASHES_PLUS = "잿더미+";

        // 힐러
        public static final String VOW_PLUS = "서약+";
        public static final String TREMOR_PLUS = "고동침+";
        public static final String ENCLOSURE_PLUS = "감쌈+";
        public static final String WAVE_PLUS = "물결+";
        public static final String SUPPRESSION_PLUS = "억압+";
        public static final String GLARE_PLUS = "빛무리+";

        // 사제
        public static final String BOND_PLUS = "결속+";
        public static final String CARTWHEEL_PLUS = "수레바퀴+";
        public static final String SACRIFICE_PLUS = "희생+";
        public static final String HOLY_WAR_PLUS = "성전+";
        public static final String WINGS_PLUS = "날개+";
        public static final String RAY_OF_LIGHT_PLUS = "빛줄기+";

        // 수도사
        public static final String KARMA_PLUS = "인과+";
        public static final String PURIFICATION_PLUS = "정화+";
        public static final String RADIANCE_PLUS = "광휘+";
        public static final String CONSECRATION_PLUS = "축성+";
        public static final String RETRIBUTION_PLUS = "응보+";
        public static final String FLAME_UP_PLUS = "업화+";

        // 음유시인
        public static final String BARD_ASSAULT_PLUS = "급습+";
        public static final String IMPROMPTU_PLUS = "즉흥+";
        public static final String DECEPTION_PLUS = "기만+";
        public static final String WIT_PLUS = "재치+";
        public static final String MOCKERY_PLUS = "조롱+";
        public static final String HARMONY_PLUS = "화음+";

        // 악사
        public static final String RESONANCE_PLUS = "공명+";
        public static final String AFFECTION_PLUS = "박애+";
        public static final String DOUBLE_NOTE_PLUS = "이중주+";
        public static final String PULSE_PLUS = "속주+";

        // 댄서
        public static final String PASSION_PLUS = "정열+";
        public static final String APPROACH_PLUS = "다가옴+";
        public static final String FRESHNESS_PLUS = "산뜻함+";
        public static final String CONCISENESS_PLUS = "간결함+";

        // 도적
        public static final String THROWING_PLUS = "투척+";
        public static final String SLYNESS_PLUS = "교활함+";
        public static final String INGENUITY_PLUS = "치밀함+";
        public static final String TOXICITY_PLUS = "독성+";

        // 격투가
        public static final String LEAP_PLUS = "도약+";
        public static final String AGILITY_FIGHTER_PLUS = "순발력+";
        public static final String PASSION_FIGHTER_PLUS = "열혈+";
        public static final String ADVANCE_PLUS = "전진+";
        public static final String COLLISION_PLUS = "충돌+";
        public static final String DEFEAT_PLUS = "격파+";

        // 듀블
        public static final String BURN_PLUS = "열상+";
        public static final String FULL_MOON_PLUS = "보름달+";
        public static final String EXPEDITIOUS_PLUS = "속행+";
        public static final String REINFORCEMENT_PLUS = "강화+";
        public static final String WHIRL_PLUS = "회오리+";
        public static final String SPRINT_PLUS = "질주+";
    }
}
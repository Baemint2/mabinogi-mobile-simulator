package com.moz1mozi.mabinogisimulator.rune;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuneTypeTest {

    @DisplayName("버튼이 runeType인지 체크한다.")
    @Test
    void test() {
        // given // when
        boolean result = RuneType.isRuneTypeButtons("hi");

        boolean armor = RuneType.isRuneTypeButtons("armor");
        // then
        assertFalse(result);

        assertTrue(armor);
    }
}
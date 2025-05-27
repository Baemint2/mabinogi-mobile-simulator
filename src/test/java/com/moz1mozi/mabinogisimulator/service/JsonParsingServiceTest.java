package com.moz1mozi.mabinogisimulator.service;

import com.moz1mozi.mabinogisimulator.rune.RuneItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class JsonParsingServiceTest {

    @Autowired
    JsonParsingService jsonParsingService;

    @DisplayName("룬 아이템 확률의 총합을 계산한다.")
    @Test
    void test() throws IOException {
        // given
        List<RuneItem> runes = jsonParsingService.getRunes();
        // when // then
        BigDecimal totalProbability = runes.stream()
                .map(runeItem -> BigDecimal.valueOf(runeItem.getProbability()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(0, RoundingMode.DOWN);

        assertThat(totalProbability).isEqualTo(BigDecimal.valueOf(100));

    }

}
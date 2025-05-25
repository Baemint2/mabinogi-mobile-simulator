package com.moz1mozi.mabinogisimulator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moz1mozi.mabinogisimulator.rune.RuneItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Slf4j
@SpringBootTest
public class JsonTest {

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("")
    @Test
    void test() throws IOException {
        // given
        List<RuneItem> file = getFile("elite.json");
        // when then
        file.forEach(runeItem -> log.info("{}", runeItem));

        List<RuneItem> file1 = getFile("epic.json");
        file1.forEach(runeItem -> log.info("{}", runeItem));

        List<RuneItem> file2 = getFile("legendary.json");
        file2.forEach(runeItem -> log.info("{}", runeItem));

    }

    private List<RuneItem> getFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        return objectMapper.readValue(fileReader,
                objectMapper.getTypeFactory().constructCollectionType(List.class, RuneItem.class));
    }
}

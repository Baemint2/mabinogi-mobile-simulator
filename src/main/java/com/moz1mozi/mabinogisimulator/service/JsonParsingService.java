package com.moz1mozi.mabinogisimulator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moz1mozi.mabinogisimulator.rune.RuneItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JsonParsingService {

    private final ObjectMapper objectMapper;
    private static final String[] RUNE_FILES = {
            "elite.json", "epic.json", "legendary.json", "fragments-rune.json"
    };

    public List<RuneItem> getRunes() throws IOException {
        List<RuneItem> allRunes = new ArrayList<>();

        for (String fileName : RUNE_FILES) {
            allRunes.addAll(getRunesFromFile(fileName));
        }

        log.info("allRunes: {}", allRunes);
        return allRunes;
    }

    private List<RuneItem> getRunesFromFile(String fileName) throws IOException {
        try (InputStream inputStream = new ClassPathResource(fileName).getInputStream()) {
            return objectMapper.readValue(inputStream,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, RuneItem.class));
        } catch (IOException e) {
            log.error("Failed to load runes from {}: {}", fileName, e.getMessage());
            throw e;
        }
    }

}

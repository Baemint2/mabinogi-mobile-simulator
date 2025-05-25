package com.moz1mozi.mabinogisimulator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moz1mozi.mabinogisimulator.rune.RuneItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JsonParsingService {

    private final ObjectMapper objectMapper;

    public List<RuneItem> getRunes() throws IOException {
        List<RuneItem> allRunes = new ArrayList<>();
        List<RuneItem> eliteRunes = getEliteRunes();
        List<RuneItem> epicRunes = getEpicRunes();
        List<RuneItem> legendaryRunes = getLegendaryRunes();
        List<RuneItem> fragmentsOfRune = getFragmentsOfRune();
        allRunes.addAll(eliteRunes);
        allRunes.addAll(epicRunes);
        allRunes.addAll(legendaryRunes);
        allRunes.addAll(fragmentsOfRune);

        log.info("eliteRunes: {}", allRunes);
        return allRunes;
    }

    private List<RuneItem> getFragmentsOfRune() throws IOException {
        return getFile("fragments.json");
    }
    private List<RuneItem> getEliteRunes() throws IOException {
        return getFile("elite.json");
    }
    private List<RuneItem> getEpicRunes() throws IOException {
        return getFile("epic.json");
    }
    private List<RuneItem> getLegendaryRunes() throws IOException {
        return getFile("legendary.json");
    }

    private List<RuneItem> getFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        return objectMapper.readValue(fileReader,
                objectMapper.getTypeFactory().constructCollectionType(List.class, RuneItem.class));
    }
}

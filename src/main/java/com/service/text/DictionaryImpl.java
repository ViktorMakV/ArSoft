package com.service.text;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Viktor Makarov
 */
@Component
public class DictionaryImpl implements Dictionary {
    private final Map<Character, Integer> charsMap;

    public DictionaryImpl() {
        charsMap = new HashMap<Character, Integer>();
        init();
    }

    public Map<Character, Integer> getDictionary() {
        return new HashMap(charsMap);
    }

    private void init() {
        addEnglishChars();
        addRussianChars();
    }

    private void addEnglishChars() {
        for (Integer i = 65; i <= 90; i++) {
            int o = i;
            charsMap.put((char) o, i - 64);
        }
    }

    private void addRussianChars() {
        for (Integer i = 1040; i <= 1071; i++) {
            int o = i;

            //Make space for Ё
            if (i - 1039 >= 7) {
                charsMap.put((char) o, i - 1038);
            } else {
                charsMap.put((char) o, i - 1039);
            }
        }
        charsMap.put('Ё', 7);
    }
}

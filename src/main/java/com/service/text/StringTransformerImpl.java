package com.service.text;

import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @author Viktor Makarov
 */
@Component
public class StringTransformerImpl implements StringTransformer {
    private Map<Character, Integer> dictionary;

    public StringTransformerImpl(Dictionary dictionary) {
        this.dictionary = dictionary.getDictionary();
    }

    //Transforms string to same string with spaces between chars.
    private String transformString(String s) {
        char[] chars = new char[s.length() * 3];
        for (int i = 0; i < s.length(); i++) {
            chars[i * 3] = s.charAt(i);
            chars[(i * 3) + 1] = ' ';
            chars[(i * 3) + 2] = ' ';
        }
        StringBuilder out = new StringBuilder();
        for (char c : chars) {
            out.append(c);
        }
        return out.toString();
    }

    //Transforms string to corresponding string of char numbers in alphabet order with spaces between chars.
    private String transformToStringWithCharNumbers(String s) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character c = Character.toUpperCase(s.charAt(i));
            if (dictionary.get(c) != null) {
                if (dictionary.get(c) < 10) {
                    out.append(dictionary.get(c));
                    out.append(" ");
                } else {
                    out.append(dictionary.get(c));
                }
                out.append(" ");
            } else {
                out.append(s.charAt(i));
                out.append("  ");
            }
        }
        return out.toString();

    }

    //Returns array of strings where even index - is original string with spaces, and odd - with chars in alphabet index.
    public String[] returnTransformedStrings(String s) {
        String[] strings = s.split("\n");
        String[] out = new String[strings.length * 2];
        for (int i = 0; i < strings.length; i++) {
            out[(i * 2)] = transformString(strings[i]).trim();
            out[(i * 2) + 1] = transformToStringWithCharNumbers(strings[i]).trim();
        }
        return out;
    }

    //Returns transformed strings composed to a single string.
    public String returnTransformedStringsAsSingleString(String s) {
        StringBuilder builder = new StringBuilder();
        for (String temp : returnTransformedStrings(s)) {
            builder.append(temp);
            builder.append("\n");
        }
        return builder.toString().trim();
    }


}

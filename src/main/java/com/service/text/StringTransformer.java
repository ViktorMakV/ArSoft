package com.service.text;

/**
 * @author Viktor Makarov
 */
public interface StringTransformer {
    String[] returnTransformedStrings(String s);
    String returnTransformedStringsAsSingleString(String s);
}

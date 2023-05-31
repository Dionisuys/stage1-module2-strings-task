package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> substrings = new ArrayList<>();
        StringBuilder currentSubstring = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);

            if (isDelimiter(currentChar, delimiters)) {
                if (!currentSubstring.isEmpty()) {
                    substrings.add(currentSubstring.toString());
                    currentSubstring = new StringBuilder();
                }
            } else {
                currentSubstring.append(currentChar);
            }
        }

        if (!currentSubstring.isEmpty()) {
            substrings.add(currentSubstring.toString());
        }

        return substrings;
    }

    private boolean isDelimiter(char character, Collection<String> delimiters) {
        for (String delimiter : delimiters) {
            if (delimiter.length() == 1 && delimiter.charAt(0) == character) {
                return true;
            }
        }
        return false;
    }
}

package com.example.utils;

public class StringUtils {
    /**
     * Trim all occurrences of the supplied leading character from the given String.
     * @param str the String to check
     * @param leadingCharacter the leading character to be trimmed
     * @return the trimmed String
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        int index = 0;
        while (index < str.length() && str.charAt(index) == leadingCharacter) {
            index++;
        }

        return str.substring(index);
    }
}
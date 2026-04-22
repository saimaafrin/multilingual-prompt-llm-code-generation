package org.springframework.util;

public class ParameterParser {
    /**
     * Determine whether a parameter name ends at the current position, that is,
     * whether the given character qualifies as a separator.
     * @param c The character to check
     * @return true if the character is a parameter separator, false otherwise
     */
    protected boolean isParameterSeparator(char c) {
        return (c == '=' || Character.isWhitespace(c));
    }
}
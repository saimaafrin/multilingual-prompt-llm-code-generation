/**
 * Determine whether a parameter name ends at the current position, that is, whether the given character qualifies as a separator.
 * 
 * @param c The character to check.
 * @return true if the character is a separator, false otherwise.
 */
private static boolean isParameterSeparator(final char c) {
    // Characters that are considered separators
    return c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == ',' || c == ';' || c == ')' || c == ']' || c == '}';
}
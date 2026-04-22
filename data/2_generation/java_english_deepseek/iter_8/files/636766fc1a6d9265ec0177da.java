/**
 * Determine whether a parameter name ends at the current position, that is, whether the given character qualifies as a separator.
 */
private static boolean isParameterSeparator(final char c) {
    // A parameter separator is typically a character that is not part of a valid parameter name.
    // Common separators include whitespace, commas, parentheses, etc.
    return Character.isWhitespace(c) || c == ',' || c == '(' || c == ')' || c == ';' || c == '=' || c == '{' || c == '}';
}
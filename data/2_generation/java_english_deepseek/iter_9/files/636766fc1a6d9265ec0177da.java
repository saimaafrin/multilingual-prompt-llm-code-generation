/**
 * Determine whether a parameter name ends at the current position, that is, whether the given character qualifies as a separator.
 */
private static boolean isParameterSeparator(final char c) {
    // Characters that are considered separators for parameter names
    return c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == ',' || c == ';' || c == ')' || c == ']' || c == '}';
}
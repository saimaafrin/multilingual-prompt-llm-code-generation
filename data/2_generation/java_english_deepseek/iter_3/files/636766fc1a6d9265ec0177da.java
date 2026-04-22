/**
 * Determine whether a parameter name ends at the current position, that is, whether the given character qualifies as a separator.
 */
private static boolean isParameterSeparator(final char c) {
    // A parameter separator can be a space, comma, semicolon, or any non-alphanumeric character.
    return !Character.isLetterOrDigit(c) && c != '_';
}
public class ParameterParser {
    /**
     * Determina se un nome di parametro termina nella posizione attuale, cioè se il carattere fornito può essere considerato un separatore.
     * Determines if a parameter name ends at the current position, i.e. if the provided character can be considered a separator.
     *
     * @param c The character to check
     * @return true if the character is a parameter separator, false otherwise
     */
    private static boolean isParameterSeparator(final char c) {
        // Common parameter separators: whitespace, equals sign, comma, semicolon
        return Character.isWhitespace(c) || c == '=' || c == ',' || c == ';';
    }
}
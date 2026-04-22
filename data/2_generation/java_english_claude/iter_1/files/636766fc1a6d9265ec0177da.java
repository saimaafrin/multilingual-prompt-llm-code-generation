public class ParameterParser {
    /**
     * Determine whether a parameter name ends at the current position, that is,
     * whether the given character qualifies as a separator.
     */
    private static boolean isParameterSeparator(final char c) {
        // Parameter name ends if character is:
        // - whitespace
        // - closing bracket )
        // - comma ,
        // - semicolon ;
        // - equals sign =
        return Character.isWhitespace(c) || 
               c == ')' ||
               c == ',' ||
               c == ';' ||
               c == '=';
    }
}
import java.util.Arrays;

public class TokenParser {

    /**
     * Parses out a token until any of the given terminators is encountered.
     * @param terminators the array of terminating characters. Any of these characters when encountered signify the end of the token
     * @return the token
     */
    private String parseToken(final char[] terminators) {
        StringBuilder token = new StringBuilder();
        int currentChar;
        
        while (true) {
            currentChar = System.in.read();
            if (currentChar == -1) {
                break; // End of input
            }
            
            char ch = (char) currentChar;
            if (containsTerminator(terminators, ch)) {
                break; // Terminator encountered
            }
            
            token.append(ch);
        }
        
        return token.toString();
    }

    /**
     * Helper method to check if a character is in the terminators array.
     * @param terminators the array of terminating characters
     * @param ch the character to check
     * @return true if the character is a terminator, false otherwise
     */
    private boolean containsTerminator(final char[] terminators, final char ch) {
        for (char terminator : terminators) {
            if (terminator == ch) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TokenParser parser = new TokenParser();
        char[] terminators = {' ', '\n', '\t', '\r'}; // Example terminators
        System.out.println("Enter input:");
        String token = parser.parseToken(terminators);
        System.out.println("Parsed token: " + token);
    }
}
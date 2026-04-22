import java.util.Arrays;

public class Parser {
    private String input;
    private int currentPosition;
    
    public Parser(String input) {
        this.input = input;
        this.currentPosition = 0;
    }

    /**
     * Parses out a token until any of the given terminators is encountered.
     * @param terminators the array of terminating characters. Any of these characters when encountered signify the end of the token
     * @return the token
     */
    private String parseToken(final char[] terminators) {
        StringBuilder token = new StringBuilder();
        
        while (currentPosition < input.length()) {
            char currentChar = input.charAt(currentPosition);
            
            // Check if current character is a terminator
            if (Arrays.binarySearch(terminators, currentChar) >= 0) {
                break;
            }
            
            token.append(currentChar);
            currentPosition++;
        }
        
        return token.toString();
    }
}
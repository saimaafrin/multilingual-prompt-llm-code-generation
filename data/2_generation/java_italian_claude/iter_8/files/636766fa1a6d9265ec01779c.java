import java.util.Arrays;

public class Parser {
    private String input;
    private int currentPosition;
    
    /**
     * Analizza un token fino a quando non viene incontrato uno dei caratteri terminatori forniti.
     * @param terminators l'array di caratteri terminatori. Qualsiasi di questi caratteri, quando incontrato, segna la fine del token
     * @return il token
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
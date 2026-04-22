import java.util.Arrays;

public class TokenParser {
    private String input;
    private int currentPosition;
    
    public TokenParser(String input) {
        this.input = input;
        this.currentPosition = 0;
    }

    public String parseToken(char[] terminators) {
        if (currentPosition >= input.length()) {
            return "";
        }

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
import java.util.Arrays;

public class Parser {
    private String input;
    private int currentPosition;
    
    public Parser(String input) {
        this.input = input;
        this.currentPosition = 0;
    }

    /**
     * Analiza un token hasta que se encuentra con cualquiera de los terminadores dados.
     * @param terminators el arreglo de caracteres terminadores. Cualquiera de estos caracteres, al ser encontrado, indica el final del token.
     * @return el token
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
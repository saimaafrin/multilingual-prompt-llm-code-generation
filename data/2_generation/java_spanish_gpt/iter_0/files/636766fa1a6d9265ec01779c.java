public class TokenParser {
    
    /**
     * Analiza un token hasta que se encuentra con cualquiera de los terminadores dados.
     * @param terminators el arreglo de caracteres terminadores. Cualquiera de estos caracteres, al ser encontrado, indica el final del token.
     * @return el token
     */
    private String parseToken(final char[] terminators) {
        StringBuilder token = new StringBuilder();
        int ch;
        
        try {
            while ((ch = System.in.read()) != -1) {
                char currentChar = (char) ch;
                if (isTerminator(currentChar, terminators)) {
                    break;
                }
                token.append(currentChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return token.toString();
    }
    
    private boolean isTerminator(char currentChar, char[] terminators) {
        for (char terminator : terminators) {
            if (currentChar == terminator) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        TokenParser parser = new TokenParser();
        char[] terminators = {' ', '\n', '\t', ',', '.'};
        String token = parser.parseToken(terminators);
        System.out.println("Parsed token: " + token);
    }
}
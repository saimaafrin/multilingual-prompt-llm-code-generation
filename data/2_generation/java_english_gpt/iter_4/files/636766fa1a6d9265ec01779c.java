public class TokenParser {
    
    /** 
     * Parses out a token until any of the given terminators is encountered.
     * @param terminators the array of terminating characters. Any of these characters when encountered signify the end of the token
     * @return the token
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
        char[] terminators = {' ', '\n', '\t', ',', ';'};
        System.out.println("Enter a token (end with a terminator):");
        String token = parser.parseToken(terminators);
        System.out.println("Parsed token: " + token);
    }
}
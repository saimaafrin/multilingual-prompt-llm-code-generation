public class TokenParser {

    /**
     * एक टोकन को पार्स करता है जब तक कि दिए गए किसी भी समाप्ति चिन्ह का सामना नहीं किया जाता।
     * @param terminators समाप्ति वर्णों का ऐरे। इनमें से कोई भी वर्ण जब सामना किया जाता है, तो यह टोकन के अंत का संकेत देता है
     * @return टोकन
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
        String token = parser.parseToken(terminators);
        System.out.println("Parsed Token: " + token);
    }
}
public class TokenParser {
    
    /**
     * 解析一个令牌，直到遇到某个给定的终止符。
     * @param terminators 终止字符数组。遇到这些字符中的任何一个都表示令牌的结束
     * @return 令牌
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
        char[] terminators = {' ', '\n', '\t', ',', '.'}; // Example terminators
        String token = parser.parseToken(terminators);
        System.out.println("Parsed token: " + token);
    }
}
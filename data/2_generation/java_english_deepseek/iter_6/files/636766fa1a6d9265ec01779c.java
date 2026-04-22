import java.util.HashSet;
import java.util.Set;

public class TokenParser {

    /**
     * Parses out a token until any of the given terminators is encountered.
     * @param terminators the array of terminating characters. Any of these characters when encountered signify the end of the token
     * @return the token
     */
    private String parseToken(final char[] terminators) {
        Set<Character> terminatorSet = new HashSet<>();
        for (char c : terminators) {
            terminatorSet.add(c);
        }

        StringBuilder token = new StringBuilder();
        int currentChar;
        while (true) {
            currentChar = System.in.read();
            if (currentChar == -1 || terminatorSet.contains((char) currentChar)) {
                break;
            }
            token.append((char) currentChar);
        }

        return token.toString();
    }

    public static void main(String[] args) {
        TokenParser parser = new TokenParser();
        char[] terminators = {' ', '\n', '\t', '\r'};
        String token = parser.parseToken(terminators);
        System.out.println("Parsed token: " + token);
    }
}
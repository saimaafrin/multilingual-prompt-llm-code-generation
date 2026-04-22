import java.util.HashSet;
import java.util.Set;

public class TokenParser {

    /**
     * Analizza un token fino a quando non viene incontrato uno dei caratteri terminatori forniti.
     * @param terminators l'array di caratteri terminatori. Qualsiasi di questi caratteri, quando incontrato, segna la fine del token
     * @return il token
     */
    private String parseToken(final char[] terminators) {
        Set<Character> terminatorSet = new HashSet<>();
        for (char c : terminators) {
            terminatorSet.add(c);
        }

        StringBuilder token = new StringBuilder();
        int currentChar;
        while (true) {
            try {
                currentChar = System.in.read();
                if (currentChar == -1 || terminatorSet.contains((char) currentChar)) {
                    break;
                }
                token.append((char) currentChar);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

        return token.toString();
    }

    public static void main(String[] args) {
        TokenParser parser = new TokenParser();
        char[] terminators = {' ', '\n', '\t', '\r'};
        String token = parser.parseToken(terminators);
        System.out.println("Token: " + token);
    }
}
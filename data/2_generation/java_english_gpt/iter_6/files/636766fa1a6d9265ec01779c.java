import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TokenParser {

    /**
     * Parses out a token until any of the given terminators is encountered.
     * @param terminators the array of terminating characters. Any of these characters when encountered signify the end of the token
     * @return the token
     */
    private String parseToken(final char[] terminators) {
        StringBuilder token = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char currentChar = (char) ch;
                for (char terminator : terminators) {
                    if (currentChar == terminator) {
                        return token.toString();
                    }
                }
                token.append(currentChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return token.toString();
    }

    public static void main(String[] args) {
        TokenParser parser = new TokenParser();
        char[] terminators = {' ', ',', ';', '\n'};
        System.out.println("Parsed Token: " + parser.parseToken(terminators));
    }
}
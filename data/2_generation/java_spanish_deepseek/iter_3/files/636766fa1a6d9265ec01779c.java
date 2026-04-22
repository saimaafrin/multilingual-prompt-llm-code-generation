import java.util.HashSet;
import java.util.Set;

public class TokenParser {

    /**
     * Analiza un token hasta que se encuentra con cualquiera de los terminadores dados.
     * @param terminators el arreglo de caracteres terminadores. Cualquiera de estos caracteres, al ser encontrado, indica el final del token.
     * @return el token
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
}
import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    StringBuilder token = new StringBuilder();
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

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
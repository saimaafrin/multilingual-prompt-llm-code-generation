import java.util.HashSet;
import java.util.Set;

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
        } catch (Exception e) {
            break;
        }

        if (currentChar == -1 || terminatorSet.contains((char) currentChar)) {
            break;
        }

        token.append((char) currentChar);
    }

    return token.toString();
}
import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    StringBuilder token = new StringBuilder();
    int ch;
    while ((ch = System.in.read()) != -1) {
        char currentChar = (char) ch;
        if (terminatorSet.contains(currentChar)) {
            break;
        }
        token.append(currentChar);
    }

    return token.toString();
}
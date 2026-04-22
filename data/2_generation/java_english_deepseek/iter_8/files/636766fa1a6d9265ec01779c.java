import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    StringBuilder token = new StringBuilder();
    int currentChar;
    while ((currentChar = System.in.read()) != -1) {
        char ch = (char) currentChar;
        if (terminatorSet.contains(ch)) {
            break;
        }
        token.append(ch);
    }

    return token.toString();
}
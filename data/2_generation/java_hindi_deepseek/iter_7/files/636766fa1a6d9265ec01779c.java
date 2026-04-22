import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    // Create a set of termination characters for quick lookup
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    StringBuilder token = new StringBuilder();
    int currentChar;

    // Read characters until a terminator is encountered
    while (true) {
        currentChar = System.in.read();
        if (currentChar == -1 || terminatorSet.contains((char) currentChar)) {
            break;
        }
        token.append((char) currentChar);
    }

    return token.toString();
}
import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    // Convert the array of terminators to a Set for O(1) lookups
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    StringBuilder tokenBuilder = new StringBuilder();
    int currentChar;

    // Read characters until a terminator is encountered
    while (true) {
        currentChar = System.in.read();
        if (currentChar == -1 || terminatorSet.contains((char) currentChar)) {
            break;
        }
        tokenBuilder.append((char) currentChar);
    }

    return tokenBuilder.toString();
}
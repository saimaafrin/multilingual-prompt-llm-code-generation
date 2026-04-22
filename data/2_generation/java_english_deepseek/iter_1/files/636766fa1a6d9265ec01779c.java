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

    // Read characters until a terminator is encountered or end of input
    while ((currentChar = System.in.read()) != -1) {
        char ch = (char) currentChar;
        if (terminatorSet.contains(ch)) {
            break;
        }
        tokenBuilder.append(ch);
    }

    return tokenBuilder.toString();
}
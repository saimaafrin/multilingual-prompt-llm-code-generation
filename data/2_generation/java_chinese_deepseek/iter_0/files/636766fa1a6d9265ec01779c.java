import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    StringBuilder token = new StringBuilder();
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    while (true) {
        char nextChar = readNextChar(); // Assuming a method to read the next character
        if (terminatorSet.contains(nextChar) {
            break;
        }
        token.append(nextChar);
    }

    return token.toString();
}

// Assuming a method to read the next character
private char readNextChar() {
    // Implementation to read the next character from the input source
    // This is a placeholder and should be implemented based on the actual input source
    return '\0'; // Placeholder return value
}
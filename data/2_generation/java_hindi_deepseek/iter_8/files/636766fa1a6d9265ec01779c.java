import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    StringBuilder token = new StringBuilder();
    char currentChar;

    while (true) {
        currentChar = readNextChar(); // Assume readNextChar() is a method that reads the next character from the input
        if (terminatorSet.contains(currentChar)) {
            break;
        }
        token.append(currentChar);
    }

    return token.toString();
}

// Assuming a method to read the next character from the input
private char readNextChar() {
    // Implementation depends on the input source (e.g., from a string, file, or stream)
    // For example, if reading from a string:
    // if (index < inputString.length()) {
    //     return inputString.charAt(index++);
    // } else {
    //     return '\0'; // End of input
    // }
    return '\0'; // Placeholder implementation
}
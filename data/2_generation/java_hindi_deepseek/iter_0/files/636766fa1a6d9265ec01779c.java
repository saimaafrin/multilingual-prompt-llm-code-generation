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
        // Assuming we have a method to get the next character from the input stream
        currentChar = getNextChar(); // You need to implement getNextChar() based on your input source

        if (currentChar == '\0' || terminatorSet.contains(currentChar)) {
            break;
        }

        token.append(currentChar);
    }

    return token.toString();
}

// Placeholder method for getting the next character from the input stream
private char getNextChar() {
    // Implement this method based on your input source (e.g., reading from a file, string, etc.)
    // For example, if reading from a string, you might use an index to track the current position
    return '\0'; // Replace with actual implementation
}
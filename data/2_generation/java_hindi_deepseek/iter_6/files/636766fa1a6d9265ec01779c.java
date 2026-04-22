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
        // Assuming input is being read from some source, e.g., System.in
        // For the sake of this example, we'll simulate reading a character
        // In a real implementation, you would replace this with actual input reading logic
        currentChar = readNextChar();

        if (terminatorSet.contains(currentChar)) {
            break;
        }

        token.append(currentChar);
    }

    return token.toString();
}

// Placeholder method to simulate reading the next character
private char readNextChar() {
    // In a real implementation, this method would read the next character from the input source
    // For example, from a file, network stream, or user input
    // Here, we'll just return a placeholder character
    return 'a'; // Replace with actual input reading logic
}
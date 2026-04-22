import java.util.HashSet;
import java.util.Set;

/**
 * एक टोकन को पार्स करता है जब तक कि दिए गए किसी भी समाप्ति चिन्ह का सामना नहीं किया जाता।
 * @param terminators समाप्ति वर्णों का ऐरे। इनमें से कोई भी वर्ण जब सामना किया जाता है, तो यह टोकन के अंत का संकेत देता है
 * @return टोकन
 */
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
    // Implementation to read the next character from the input
    // This is a placeholder and should be implemented based on the actual input source
    return ' '; // Placeholder return value
}
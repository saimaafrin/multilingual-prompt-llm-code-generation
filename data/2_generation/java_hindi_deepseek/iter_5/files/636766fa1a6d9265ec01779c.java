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
        try {
            currentChar = System.in.read();
        } catch (Exception e) {
            // Handle any IO exceptions
            e.printStackTrace();
            break;
        }

        // Check if the current character is a terminator
        if (currentChar == -1 || terminatorSet.contains((char) currentChar)) {
            break;
        }

        // Append the character to the token
        token.append((char) currentChar);
    }

    return token.toString();
}
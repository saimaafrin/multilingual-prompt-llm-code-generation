import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    StringBuilder token = new StringBuilder();
    int currentChar;
    
    while (true) {
        currentChar = System.in.read();
        if (currentChar == -1) { // End of input
            break;
        }
        char ch = (char) currentChar;
        if (terminatorSet.contains(ch)) {
            break;
        }
        token.append(ch);
    }

    return token.toString();
}
import java.util.regex.Matcher;
import java.util.regex.Pattern;

private String unescapeId(String input) {
    if (input == null) {
        return null;
    }

    // Replace escaped quotes and backslashes
    StringBuilder unescaped = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
        char currentChar = input.charAt(i);
        if (currentChar == '\\' && i + 1 < input.length()) {
            char nextChar = input.charAt(i + 1);
            if (nextChar == '"' || nextChar == '\\') {
                unescaped.append(nextChar);
                i++; // Skip the next character
            } else {
                unescaped.append(currentChar);
            }
        } else {
            unescaped.append(currentChar);
        }
    }

    return unescaped.toString();
}
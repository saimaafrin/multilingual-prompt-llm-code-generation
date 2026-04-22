import java.util.regex.Matcher;
import java.util.regex.Pattern;

private String unescapeId(String input) {
    if (input == null) {
        return null;
    }

    // Replace escaped sequences with their corresponding characters
    StringBuilder output = new StringBuilder();
    int length = input.length();
    for (int i = 0; i < length; i++) {
        char currentChar = input.charAt(i);
        if (currentChar == '\\' && i + 1 < length) {
            char nextChar = input.charAt(i + 1);
            switch (nextChar) {
                case '\\':
                    output.append('\\');
                    i++;
                    break;
                case '"':
                    output.append('"');
                    i++;
                    break;
                case 'n':
                    output.append('\n');
                    i++;
                    break;
                case 't':
                    output.append('\t');
                    i++;
                    break;
                case 'r':
                    output.append('\r');
                    i++;
                    break;
                default:
                    output.append(currentChar);
                    break;
            }
        } else {
            output.append(currentChar);
        }
    }

    return output.toString();
}
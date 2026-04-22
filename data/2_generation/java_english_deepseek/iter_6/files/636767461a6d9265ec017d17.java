import java.util.regex.Matcher;
import java.util.regex.Pattern;

private String unescapeId(String input) {
    if (input == null) {
        return null;
    }

    // Replace escaped quotes and backslashes
    input = input.replace("\\\"", "\"");
    input = input.replace("\\\\", "\\");

    // Replace escaped newlines, tabs, etc.
    input = input.replace("\\n", "\n");
    input = input.replace("\\r", "\r");
    input = input.replace("\\t", "\t");

    // Replace Unicode escape sequences
    Pattern unicodePattern = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
    Matcher matcher = unicodePattern.matcher(input);
    StringBuffer unescapedBuffer = new StringBuffer();

    while (matcher.find()) {
        String hex = matcher.group(1);
        char unicodeChar = (char) Integer.parseInt(hex, 16);
        matcher.appendReplacement(unescapedBuffer, Character.toString(unicodeChar));
    }
    matcher.appendTail(unescapedBuffer);

    return unescapedBuffer.toString();
}
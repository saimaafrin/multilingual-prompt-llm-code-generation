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

    // Replace other escaped characters
    Pattern pattern = Pattern.compile("\\\\(.)");
    Matcher matcher = pattern.matcher(input);
    StringBuffer sb = new StringBuffer();

    while (matcher.find()) {
        matcher.appendReplacement(sb, matcher.group(1));
    }
    matcher.appendTail(sb);

    return sb.toString();
}
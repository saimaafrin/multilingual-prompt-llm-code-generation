import java.util.regex.Matcher;
import java.util.regex.Pattern;

private String unescapeId(String input) {
    if (input == null) {
        return null;
    }

    // Pattern to match escaped characters in DOT identifiers
    Pattern pattern = Pattern.compile("\\\\([\\\\\"])");
    Matcher matcher = pattern.matcher(input);

    // Replace escaped characters with their unescaped counterparts
    StringBuffer unescapedString = new StringBuffer();
    while (matcher.find()) {
        matcher.appendReplacement(unescapedString, matcher.group(1));
    }
    matcher.appendTail(unescapedString);

    return unescapedString.toString();
}
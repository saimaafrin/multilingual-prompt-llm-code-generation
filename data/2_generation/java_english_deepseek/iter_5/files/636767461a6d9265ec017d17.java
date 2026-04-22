import java.util.regex.Matcher;
import java.util.regex.Pattern;

private String unescapeId(String input) {
    if (input == null) {
        return null;
    }
    
    // Pattern to match escaped characters
    Pattern pattern = Pattern.compile("\\\\(.)");
    Matcher matcher = pattern.matcher(input);
    StringBuffer unescaped = new StringBuffer();
    
    while (matcher.find()) {
        // Replace the escaped character with the actual character
        matcher.appendReplacement(unescaped, Matcher.quoteReplacement(matcher.group(1)));
    }
    matcher.appendTail(unescaped);
    
    return unescaped.toString();
}
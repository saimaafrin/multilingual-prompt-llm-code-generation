import java.util.regex.Matcher;
import java.util.regex.Pattern;

private String unescapeId(String input) {
    // Pattern to match escaped characters in DOT format
    Pattern pattern = Pattern.compile("\\\\([\\\\\"])");
    Matcher matcher = pattern.matcher(input);
    
    // Replace escaped characters with their unescaped versions
    StringBuffer result = new StringBuffer();
    while (matcher.find()) {
        matcher.appendReplacement(result, matcher.group(1));
    }
    matcher.appendTail(result);
    
    return result.toString();
}
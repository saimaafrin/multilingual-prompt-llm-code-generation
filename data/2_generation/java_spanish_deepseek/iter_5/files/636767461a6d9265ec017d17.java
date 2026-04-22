import java.util.regex.Pattern;
import java.util.regex.Matcher;

private String unescapeId(String input) {
    if (input == null) {
        return null;
    }
    
    // Define the pattern for escaped characters
    Pattern pattern = Pattern.compile("\\\\(.)");
    Matcher matcher = pattern.matcher(input);
    
    // Use a StringBuffer to build the result
    StringBuffer result = new StringBuffer();
    
    while (matcher.find()) {
        // Replace the escaped character with the actual character
        matcher.appendReplacement(result, matcher.group(1));
    }
    
    // Append the remaining part of the input
    matcher.appendTail(result);
    
    return result.toString();
}
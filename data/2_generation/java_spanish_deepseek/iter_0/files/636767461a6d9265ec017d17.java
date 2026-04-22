import java.util.regex.Matcher;
import java.util.regex.Pattern;

private String unescapeId(String input) {
    if (input == null) {
        return null;
    }
    
    // Replace escaped quotes and backslashes
    String unescaped = input.replaceAll("\\\\([\"\\\\])", "$1");
    
    // Replace escaped newlines, tabs, etc.
    unescaped = unescaped.replaceAll("\\\\n", "\n")
                         .replaceAll("\\\\t", "\t")
                         .replaceAll("\\\\r", "\r")
                         .replaceAll("\\\\b", "\b")
                         .replaceAll("\\\\f", "\f");
    
    return unescaped;
}
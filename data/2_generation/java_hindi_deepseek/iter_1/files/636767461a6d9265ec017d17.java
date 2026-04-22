import java.util.regex.Matcher;
import java.util.regex.Pattern;

private String unescapeId(String input) {
    if (input == null) {
        return null;
    }
    
    // Replace escaped dots with actual dots
    String unescaped = input.replace("\\.", ".");
    
    // Replace escaped backslashes with actual backslashes
    unescaped = unescaped.replace("\\\\", "\\");
    
    return unescaped;
}
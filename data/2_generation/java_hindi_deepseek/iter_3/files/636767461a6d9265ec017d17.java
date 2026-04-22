import java.util.regex.Matcher;
import java.util.regex.Pattern;

private String unescapeId(String input) {
    if (input == null) {
        return null;
    }
    
    // Replace escaped sequences with their unescaped counterparts
    input = input.replace("\\\\.", ".");
    input = input.replace("\\\\\\", "\\");
    
    return input;
}
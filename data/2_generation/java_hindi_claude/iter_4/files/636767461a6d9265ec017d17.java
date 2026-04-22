import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringUnescaper {
    
    /**
     * Unescape a string DOT identifier.
     * @param input the input
     * @return the unescaped output
     */
    public static String unescapeDotIdentifier(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Handle quoted strings
        if (input.startsWith("\"") && input.endsWith("\"")) {
            String inner = input.substring(1, input.length() - 1);
            
            // Replace escaped quotes
            inner = inner.replace("\\\"", "\"");
            
            // Replace escaped newlines
            inner = inner.replace("\\n", "\n");
            
            // Replace escaped tabs
            inner = inner.replace("\\t", "\t");
            
            // Replace escaped backslashes
            inner = inner.replace("\\\\", "\\");
            
            return inner;
        }

        // Handle unquoted identifiers
        Pattern escapePattern = Pattern.compile("\\\\(.)", Pattern.DOTALL);
        Matcher matcher = escapePattern.matcher(input);
        StringBuffer result = new StringBuffer();
        
        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1));
        }
        matcher.appendTail(result);
        
        return result.toString();
    }
}
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DotUtils {

    /**
     * Unescape a string DOT identifier.
     * @param input the input
     * @return the unescaped output
     */
    private String unescapeId(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Handle quoted strings
        if (input.startsWith("\"") && input.endsWith("\"")) {
            // Remove quotes
            String unquoted = input.substring(1, input.length() - 1);
            
            // Replace escaped quotes
            unquoted = unquoted.replace("\\\"", "\"");
            
            // Replace escaped newlines
            unquoted = unquoted.replace("\\n", "\n");
            
            // Replace escaped tabs
            unquoted = unquoted.replace("\\t", "\t");
            
            // Replace double backslashes
            unquoted = unquoted.replace("\\\\", "\\");
            
            return unquoted;
        }

        // Handle HTML-like escapes
        Pattern pattern = Pattern.compile("&#([0-9]+);");
        Matcher matcher = pattern.matcher(input);
        StringBuffer result = new StringBuffer();
        
        while (matcher.find()) {
            String replacement = String.valueOf((char)Integer.parseInt(matcher.group(1)));
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);

        return result.toString();
    }
}
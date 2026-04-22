import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TemplateEncoder {
    public static String encodeTemplateNames(String s) {
        if (s == null) {
            return null;
        }
        
        // Create a pattern to match '{' and '}'
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(s);
        
        // Use a StringBuffer to build the result
        StringBuffer result = new StringBuffer();
        
        while (matcher.find()) {
            // Replace '{' with '%7B' and '}' with '%7D'
            String replacement = matcher.group().equals("{") ? "%7B" : "%7D";
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);
        
        return result.toString();
    }
}
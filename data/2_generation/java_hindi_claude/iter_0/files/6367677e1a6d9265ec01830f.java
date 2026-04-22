import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatter {

    /**
     * Produces a formatted string as specified by the conversion pattern.
     * @param pattern The pattern containing format specifiers
     * @param args The arguments to format
     * @return The formatted string with arguments inserted
     */
    public static String format(String pattern, Object... args) {
        if (pattern == null) {
            return null;
        }
        
        if (args == null || args.length == 0) {
            return pattern;
        }

        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile("%[sdf]");
        Matcher m = p.matcher(pattern);
        
        int argIndex = 0;
        int lastMatch = 0;
        
        while (m.find() && argIndex < args.length) {
            // Append text before the format specifier
            result.append(pattern.substring(lastMatch, m.start()));
            
            // Get the format specifier
            String specifier = m.group();
            
            // Format based on specifier type
            switch (specifier) {
                case "%s":
                    result.append(String.valueOf(args[argIndex]));
                    break;
                case "%d":
                    if (args[argIndex] instanceof Number) {
                        result.append(((Number)args[argIndex]).longValue());
                    } else {
                        result.append(args[argIndex]);
                    }
                    break;
                case "%f":
                    if (args[argIndex] instanceof Number) {
                        result.append(((Number)args[argIndex]).doubleValue());
                    } else {
                        result.append(args[argIndex]);
                    }
                    break;
            }
            
            lastMatch = m.end();
            argIndex++;
        }
        
        // Append remaining text after last format specifier
        if (lastMatch < pattern.length()) {
            result.append(pattern.substring(lastMatch));
        }
        
        return result.toString();
    }
}
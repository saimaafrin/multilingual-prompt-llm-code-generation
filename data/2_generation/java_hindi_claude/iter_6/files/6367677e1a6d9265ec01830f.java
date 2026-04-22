import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatter {

    /**
     * Produces a formatted string as specified by the conversion pattern.
     * @param pattern The pattern string containing conversion specifiers
     * @param args Variable arguments to be formatted according to pattern
     * @return The formatted string with conversions applied
     */
    public static String format(String pattern, Object... args) {
        if (pattern == null) {
            return null;
        }
        
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile("%[a-zA-Z]");
        Matcher m = p.matcher(pattern);
        
        int argIndex = 0;
        int lastMatch = 0;
        
        while (m.find()) {
            // Add text before the conversion specifier
            result.append(pattern.substring(lastMatch, m.start()));
            
            // Get the conversion character
            char conversion = pattern.charAt(m.end() - 1);
            
            // Format argument based on conversion type
            if (argIndex < args.length) {
                switch (conversion) {
                    case 'd':
                        if (args[argIndex] instanceof Number) {
                            result.append(((Number)args[argIndex]).longValue());
                        }
                        break;
                    case 'f':
                        if (args[argIndex] instanceof Number) {
                            DecimalFormat df = new DecimalFormat("#.######");
                            result.append(df.format(args[argIndex]));
                        }
                        break;
                    case 's':
                        result.append(String.valueOf(args[argIndex]));
                        break;
                    case 't':
                        if (args[argIndex] instanceof Date) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            result.append(sdf.format((Date)args[argIndex]));
                        }
                        break;
                    default:
                        result.append(m.group()); // Unknown conversion, keep as-is
                }
                argIndex++;
            } else {
                result.append(m.group()); // No more arguments, keep pattern as-is
            }
            
            lastMatch = m.end();
        }
        
        // Add remaining text after last conversion
        if (lastMatch < pattern.length()) {
            result.append(pattern.substring(lastMatch));
        }
        
        return result.toString();
    }
}
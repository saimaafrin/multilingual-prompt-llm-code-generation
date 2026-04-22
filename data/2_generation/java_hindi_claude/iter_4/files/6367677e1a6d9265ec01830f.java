import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatter {

    /**
     * Produces a formatted string as specified by the conversion pattern.
     * @param pattern The pattern string containing conversion specifications
     * @param args The arguments referenced by the format specifiers in pattern
     * @return The formatted string
     */
    public static String format(String pattern, Object... args) {
        if (pattern == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile("%([0-9]+\\$)?([-#+ 0,(<]*)([0-9]+)?(\\.([0-9]+))?([bBhHsScCdoxXeEfgGaA%n])|%%");
        Matcher m = p.matcher(pattern);
        
        int argIndex = 0;
        
        while (m.find()) {
            // Add the text before the match
            result.append(pattern.substring(0, m.start()));
            
            // Handle %% escape sequence
            if (m.group().equals("%%")) {
                result.append("%");
                pattern = pattern.substring(m.end());
                continue;
            }
            
            // Get the argument position if specified
            String positionalSpecifier = m.group(1);
            int position = positionalSpecifier != null ? 
                Integer.parseInt(positionalSpecifier.substring(0, positionalSpecifier.length() - 1)) - 1 : 
                argIndex++;
                
            if (position >= args.length) {
                throw new IllegalArgumentException("Argument index out of bounds");
            }
            
            // Get flags and width/precision
            String flags = m.group(2);
            String width = m.group(3);
            String precision = m.group(5);
            String conversion = m.group(6);
            
            // Format the argument based on conversion type
            String formatted = formatArg(args[position], flags, width, precision, conversion);
            result.append(formatted);
            
            // Update pattern to continue processing
            pattern = pattern.substring(m.end());
        }
        
        // Add any remaining text
        result.append(pattern);
        
        return result.toString();
    }
    
    private static String formatArg(Object arg, String flags, String width, String precision, String conversion) {
        StringBuilder format = new StringBuilder("%");
        if (flags != null) format.append(flags);
        if (width != null) format.append(width);
        if (precision != null) format.append(".").append(precision);
        format.append(conversion);
        
        switch (conversion.charAt(0)) {
            case 'd':
            case 'x':
            case 'X':
            case 'o':
                return String.format(format.toString(), ((Number)arg).longValue());
            case 'e':
            case 'E':
            case 'f':
            case 'g':
            case 'G':
            case 'a':
            case 'A':
                return String.format(format.toString(), ((Number)arg).doubleValue());
            case 'b':
            case 'B':
                return String.format(format.toString(), arg);
            case 'h':
            case 'H':
                return String.format(format.toString(), arg.hashCode());
            case 's':
            case 'S':
                return String.format(format.toString(), arg.toString());
            case 'c':
            case 'C':
                return String.format(format.toString(), (char)((Number)arg).intValue());
            default:
                throw new IllegalArgumentException("Unknown conversion type: " + conversion);
        }
    }
}
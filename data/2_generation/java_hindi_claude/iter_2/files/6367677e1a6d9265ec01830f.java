import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatter {

    /**
     * Produces a formatted string as specified by the conversion pattern.
     * @param pattern The pattern string containing conversion specifications
     * @param args The arguments referenced by the format specifiers in the pattern
     * @return The formatted string
     */
    public static String format(String pattern, Object... args) {
        if (pattern == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        Pattern formatPattern = Pattern.compile("%([0-9]+\\$)?([-#+ 0,(<]*)([0-9]+)?(\\.([0-9]+))?([bBhHsScCdoxXeEfgGaA%n])|%%");
        Matcher matcher = formatPattern.matcher(pattern);
        
        int position = 0;
        int argIndex = 0;
        
        while (matcher.find()) {
            // Add the text before the format specifier
            result.append(pattern.substring(position, matcher.start()));
            position = matcher.end();
            
            // Handle %% escape sequence
            if (matcher.group().equals("%%")) {
                result.append('%');
                continue;
            }
            
            // Get format specifier components
            String indexStr = matcher.group(1);
            String flags = matcher.group(2);
            String width = matcher.group(3);
            String precision = matcher.group(5);
            String conversion = matcher.group(6);
            
            // Get argument index
            int index = indexStr != null ? 
                Integer.parseInt(indexStr.substring(0, indexStr.length() - 1)) - 1 : 
                argIndex++;
                
            if (index >= args.length) {
                throw new IllegalArgumentException("Argument index out of bounds");
            }
            
            // Format the argument based on conversion type
            String formatted = formatArg(args[index], flags, width, precision, conversion);
            result.append(formatted);
        }
        
        // Add remaining text after last format specifier
        result.append(pattern.substring(position));
        
        return result.toString();
    }
    
    private static String formatArg(Object arg, String flags, String width, String precision, String conversion) {
        if (arg == null) {
            return "null";
        }
        
        String result;
        switch (conversion.charAt(0)) {
            case 's':
                result = arg.toString();
                break;
            case 'd':
                result = formatNumber(arg, flags, "#,##0");
                break;
            case 'f':
                String pattern = "#,##0" + (precision != null ? "." + "0".repeat(Integer.parseInt(precision)) : ".0");
                result = formatNumber(arg, flags, pattern);
                break;
            case 'x':
            case 'X':
                result = Integer.toHexString(((Number)arg).intValue());
                if (conversion.equals("X")) {
                    result = result.toUpperCase();
                }
                break;
            default:
                result = arg.toString();
        }
        
        // Apply width padding
        if (width != null) {
            int padWidth = Integer.parseInt(width);
            if (result.length() < padWidth) {
                char padChar = flags != null && flags.contains("0") ? '0' : ' ';
                boolean leftAlign = flags != null && flags.contains("-");
                String padding = String.valueOf(padChar).repeat(padWidth - result.length());
                result = leftAlign ? result + padding : padding + result;
            }
        }
        
        return result;
    }
    
    private static String formatNumber(Object number, String flags, String pattern) {
        DecimalFormat df = new DecimalFormat(pattern);
        if (flags != null && flags.contains("+") && number instanceof Number) {
            double value = ((Number)number).doubleValue();
            return value >= 0 ? "+" + df.format(value) : df.format(value);
        }
        return df.format(number);
    }
}
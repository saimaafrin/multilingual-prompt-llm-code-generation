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
        String result;
        
        switch (conversion.charAt(0)) {
            case 's':
                result = String.valueOf(arg);
                if (precision != null) {
                    result = result.substring(0, Math.min(result.length(), Integer.parseInt(precision)));
                }
                break;
                
            case 'd':
                DecimalFormat df = new DecimalFormat();
                df.setGroupingUsed(flags != null && flags.contains(","));
                result = df.format(((Number)arg).longValue());
                break;
                
            case 'f':
                DecimalFormat ff = new DecimalFormat();
                ff.setGroupingUsed(flags != null && flags.contains(","));
                if (precision != null) {
                    ff.setMaximumFractionDigits(Integer.parseInt(precision));
                    ff.setMinimumFractionDigits(Integer.parseInt(precision));
                }
                result = ff.format(((Number)arg).doubleValue());
                break;
                
            case 't':
                SimpleDateFormat sdf = new SimpleDateFormat();
                result = sdf.format((Date)arg);
                break;
                
            default:
                result = String.valueOf(arg);
        }
        
        // Handle width padding
        if (width != null) {
            int w = Integer.parseInt(width);
            if (result.length() < w) {
                String padding = flags != null && flags.contains("0") ? "0" : " ";
                while (result.length() < w) {
                    result = flags != null && flags.contains("-") ? 
                        result + padding : 
                        padding + result;
                }
            }
        }
        
        return result;
    }
}
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyUtils {
    /**
     * Find the value corresponding to <code>key</code> in <code>props</code>. 
     * Then perform variable substitution on the found value.
     */
    public static String findAndSubst(String key, Properties props) {
        if (key == null || props == null) {
            return null;
        }

        String value = props.getProperty(key);
        if (value == null) {
            return null;
        }

        // Pattern to match ${variable} format
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        // Replace each ${variable} with its value from properties
        while (matcher.find()) {
            String varName = matcher.group(1);
            String replacement = props.getProperty(varName);
            
            // If no replacement found, leave original ${variable}
            if (replacement == null) {
                replacement = "${" + varName + "}";
            }
            
            // Quote replacement string to handle special regex chars
            matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(result);

        return result.toString();
    }
}
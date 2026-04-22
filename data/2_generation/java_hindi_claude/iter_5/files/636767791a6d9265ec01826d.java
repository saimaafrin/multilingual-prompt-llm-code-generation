import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyResolver {

    /**
     * Find the value corresponding to <code>key</code> in <code>props</code>. Then perform variable substitution on the found value.
     * @param key The property key to look up
     * @param props The Properties object containing key-value pairs
     * @return The resolved property value with variables substituted
     */
    public String resolveProperty(String key, Properties props) {
        if (key == null || props == null) {
            return null;
        }

        String value = props.getProperty(key);
        if (value == null) {
            return null;
        }

        // Pattern to match ${variable} syntax
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        // Replace each ${var} with its value from properties
        while (matcher.find()) {
            String varName = matcher.group(1);
            String replacement = props.getProperty(varName);
            
            // If no replacement found, leave original ${var} text
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
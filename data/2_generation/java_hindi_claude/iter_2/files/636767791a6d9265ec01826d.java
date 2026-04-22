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

        while (matcher.find()) {
            String varName = matcher.group(1);
            String replacement = props.getProperty(varName);
            
            // If variable not found, leave as-is
            if (replacement == null) {
                replacement = "${" + varName + "}";
            }
            
            // Escape $ and \ in replacement string
            replacement = replacement.replace("\\", "\\\\").replace("$", "\\$");
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);

        return result.toString();
    }
}
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyUtils {

    /**
     * Encuentra el valor correspondiente a <code>key</code> en <code>props</code>. 
     * Luego realiza la sustitución de variables en el valor encontrado.
     */
    public static String findAndSubst(String key, Properties props) {
        if (key == null || props == null) {
            return null;
        }

        String value = props.getProperty(key);
        if (value == null) {
            return null;
        }

        // Pattern to find ${variable} references
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        // Replace each ${variable} with its value from props
        while (matcher.find()) {
            String varName = matcher.group(1);
            String replacement = props.getProperty(varName);
            
            // If variable not found, leave the original ${variable} text
            if (replacement == null) {
                replacement = "${" + varName + "}";
            }
            
            // Quote replacement string to avoid issues with $ and backslashes
            matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(result);

        return result.toString();
    }
}
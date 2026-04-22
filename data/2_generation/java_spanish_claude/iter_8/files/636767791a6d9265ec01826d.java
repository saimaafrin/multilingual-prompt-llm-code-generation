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

        // Pattern to match ${variable} format
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String varName = matcher.group(1);
            String varValue = props.getProperty(varName);
            
            // If variable not found, leave original ${varName}
            if (varValue == null) {
                varValue = "${" + varName + "}";
            }
            
            // Escape $ and \ for replacement
            varValue = varValue.replace("\\", "\\\\").replace("$", "\\$");
            matcher.appendReplacement(result, varValue);
        }
        matcher.appendTail(result);

        return result.toString();
    }
}
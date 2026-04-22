import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyUtils {

    /**
     * 在 <code>props</code> 中查找与 <code>key</code> 对应的值。然后对找到的值进行变量替换。
     */
    public static String findAndSubst(String key, Properties props) {
        if (key == null || props == null) {
            return null;
        }

        String value = props.getProperty(key);
        if (value == null) {
            return null;
        }

        // Pattern for ${var} style variables
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        // Replace all variables
        while (matcher.find()) {
            String varName = matcher.group(1);
            String varValue = props.getProperty(varName);
            
            // If variable not found, keep original ${var}
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
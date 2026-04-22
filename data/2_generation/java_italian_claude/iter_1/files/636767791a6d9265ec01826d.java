import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyUtils {

    /**
     * Trova il valore corrispondente a <code>key</code> in <code>props</code>. 
     * Quindi esegui la sostituzione delle variabili sul valore trovato.
     */
    public static String findAndSubst(String key, Properties props) {
        if (key == null || props == null) {
            return null;
        }

        String value = props.getProperty(key);
        if (value == null) {
            return null;
        }

        // Pattern per trovare variabili del tipo ${var}
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String varName = matcher.group(1);
            String replacement = props.getProperty(varName);
            
            // Se la variabile non è definita, lascia il placeholder originale
            if (replacement == null) {
                replacement = "${" + varName + "}";
            }
            
            // Escape dei caratteri speciali nella stringa di sostituzione
            replacement = Matcher.quoteReplacement(replacement);
            matcher.appendReplacement(result, replacement);
        }
        
        matcher.appendTail(result);
        return result.toString();
    }
}
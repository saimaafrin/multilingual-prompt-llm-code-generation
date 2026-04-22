import java.util.Properties;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertySubstitutor {

    public static String findAndSubst(String key, Properties props) {
        // Ottieni il valore associato alla chiave
        String value = props.getProperty(key);
        if (value == null) {
            return null; // Se la chiave non esiste, restituisci null
        }

        // Pattern per trovare le variabili nel formato ${var}
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        // Sostituisci ogni variabile con il valore corrispondente
        while (matcher.find()) {
            String varName = matcher.group(1);
            String varValue = props.getProperty(varName, "");
            matcher.appendReplacement(result, Matcher.quoteReplacement(varValue));
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("name", "John");
        props.setProperty("greeting", "Hello, ${name}!");

        String result = findAndSubst("greeting", props);
        System.out.println(result); // Output: Hello, John!
    }
}
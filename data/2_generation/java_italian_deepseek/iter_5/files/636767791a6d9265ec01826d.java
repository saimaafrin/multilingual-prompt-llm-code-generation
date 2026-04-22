import java.util.Properties;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertySubstitutor {

    public static String findAndSubst(String key, Properties props) {
        // Ottieni il valore corrispondente alla chiave
        String value = props.getProperty(key);
        if (value == null) {
            return null; // Se la chiave non esiste, restituisci null
        }

        // Pattern per trovare le variabili nel formato ${variabile}
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        // Sostituisci ogni variabile trovata con il valore corrispondente
        while (matcher.find()) {
            String variable = matcher.group(1);
            String replacement = props.getProperty(variable, "");
            matcher.appendReplacement(result, replacement);
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
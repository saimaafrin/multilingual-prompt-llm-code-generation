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

        // Buffer per costruire la stringa risultante
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String varName = matcher.group(1); // Nome della variabile
            String varValue = props.getProperty(varName); // Valore della variabile

            // Se la variabile esiste, sostituisci, altrimenti lascia il placeholder
            String replacement = (varValue != null) ? varValue : matcher.group();
            matcher.appendReplacement(result, replacement);
        }

        matcher.appendTail(result); // Aggiungi il resto della stringa

        return result.toString();
    }

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("greeting", "Hello, ${name}!");
        props.setProperty("name", "World");

        String result = findAndSubst("greeting", props);
        System.out.println(result); // Output: Hello, World!
    }
}
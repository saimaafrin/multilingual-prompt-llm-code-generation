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

        // Trova tutte le variabili nel valore (formato ${variabile})
        Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String variable = matcher.group(1); // Ottieni il nome della variabile
            String replacement = props.getProperty(variable); // Trova il valore della variabile
            if (replacement != null) {
                // Sostituisci la variabile con il valore trovato
                matcher.appendReplacement(result, replacement);
            } else {
                // Se la variabile non esiste, lascia il placeholder invariato
                matcher.appendReplacement(result, matcher.group(0));
            }
        }
        matcher.appendTail(result);

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
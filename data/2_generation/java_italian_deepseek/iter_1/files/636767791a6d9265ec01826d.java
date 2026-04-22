import java.util.Properties;

public class PropertySubstitutor {

    /**
     * Trova il valore corrispondente a <code>key</code> in <code>props</code>. Quindi esegui la sostituzione delle variabili sul valore trovato.
     */
    public static String findAndSubst(String key, Properties props) {
        if (key == null || props == null) {
            throw new IllegalArgumentException("Key and properties must not be null");
        }

        String value = props.getProperty(key);
        if (value == null) {
            return null;
        }

        // Esegui la sostituzione delle variabili
        for (String propKey : props.stringPropertyNames()) {
            String propValue = props.getProperty(propKey);
            value = value.replace("${" + propKey + "}", propValue);
        }

        return value;
    }

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("name", "John");
        props.setProperty("greeting", "Hello, ${name}!");

        String result = findAndSubst("greeting", props);
        System.out.println(result);  // Output: Hello, John!
    }
}
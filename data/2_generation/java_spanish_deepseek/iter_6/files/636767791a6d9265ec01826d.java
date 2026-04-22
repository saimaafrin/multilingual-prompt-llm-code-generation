import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertySubstitutor {

    /**
     * Encuentra el valor correspondiente a <code>key</code> en <code>props</code>. Luego realiza la sustitución de variables en el valor encontrado.
     * 
     * @param key   La clave para buscar en las propiedades.
     * @param props Las propiedades que contienen los valores.
     * @return El valor sustituido o null si la clave no existe.
     */
    public static String findAndSubst(String key, Properties props) {
        String value = props.getProperty(key);
        if (value == null) {
            return null;
        }

        // Expresión regular para encontrar patrones de sustitución como ${key}
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String placeholderKey = matcher.group(1);
            String placeholderValue = props.getProperty(placeholderKey, "");
            matcher.appendReplacement(result, placeholderValue);
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("greeting", "Hello, ${name}!");
        props.setProperty("name", "World");

        String result = findAndSubst("greeting", props);
        System.out.println(result);  // Output: Hello, World!
    }
}
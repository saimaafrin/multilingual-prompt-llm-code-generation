import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertySubstitutor {

    /**
     * Encuentra el valor correspondiente a <code>key</code> en <code>props</code>. 
     * Luego realiza la sustitución de variables en el valor encontrado.
     * 
     * @param key   La clave para buscar en las propiedades.
     * @param props Las propiedades que contienen los valores.
     * @return El valor correspondiente a la clave con las variables sustituidas.
     */
    public static String findAndSubst(String key, Properties props) {
        String value = props.getProperty(key);
        if (value == null) {
            return null;
        }

        // Expresión regular para encontrar variables en el formato ${variable}
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

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
        props.setProperty("greeting", "Hello, ${name}!");
        props.setProperty("name", "World");

        String result = findAndSubst("greeting", props);
        System.out.println(result);  // Output: Hello, World!
    }
}
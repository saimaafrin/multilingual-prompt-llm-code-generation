import java.util.Properties;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertySubstitutor {

    public static String findAndSubst(String key, Properties props) {
        // Obtener el valor asociado a la clave
        String value = props.getProperty(key);
        if (value == null) {
            return null; // Si no se encuentra la clave, retornar null
        }

        // Expresión regular para encontrar variables en el formato ${variable}
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        // Realizar la sustitución de variables
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
        System.out.println(result); // Output: Hello, World!
    }
}
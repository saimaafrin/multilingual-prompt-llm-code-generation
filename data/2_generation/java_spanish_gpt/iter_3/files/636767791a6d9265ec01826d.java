import java.util.Properties;

public class VariableSubstitutor {

    /** 
     * Encuentra el valor correspondiente a <code>key</code> en <code>props</code>. Luego realiza la sustitución de variables en el valor encontrado.
     */
    public static String findAndSubst(String key, Properties props) {
        String value = props.getProperty(key);
        if (value == null) {
            return null; // o lanzar una excepción si se prefiere
        }

        // Realiza la sustitución de variables
        for (String propKey : props.stringPropertyNames()) {
            String placeholder = "${" + propKey + "}";
            value = value.replace(placeholder, props.getProperty(propKey));
        }

        return value;
    }

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("name", "John");
        props.setProperty("greeting", "Hello, ${name}!");

        String result = findAndSubst("greeting", props);
        System.out.println(result); // Debería imprimir: Hello, John!
    }
}
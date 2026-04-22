import java.util.Properties;

public class PropertySubstitutor {

    /**
     * Encuentra el valor correspondiente a <code>key</code> en <code>props</code>. Luego realiza la sustitución de variables en el valor encontrado.
     */
    public static String findAndSubst(String key, Properties props) {
        String value = props.getProperty(key);
        if (value == null) {
            return null;
        }

        // Perform variable substitution
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < value.length()) {
            char c = value.charAt(i);
            if (c == '$' && i + 1 < value.length() && value.charAt(i + 1) == '{') {
                // Start of a variable
                int j = value.indexOf('}', i + 2);
                if (j != -1) {
                    String varKey = value.substring(i + 2, j);
                    String varValue = props.getProperty(varKey);
                    if (varValue != null) {
                        result.append(varValue);
                    } else {
                        result.append("${").append(varKey).append("}");
                    }
                    i = j + 1;
                } else {
                    result.append(c);
                    i++;
                }
            } else {
                result.append(c);
                i++;
            }
        }

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
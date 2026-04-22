import java.util.Properties;

public class VariableSubstitution {

    /** 
     * Find the value corresponding to <code>key</code> in <code>props</code>. Then perform variable substitution on the found value.
     */
    public static String findAndSubst(String key, Properties props) {
        String value = props.getProperty(key);
        if (value == null) {
            return null; // or throw an exception based on your needs
        }

        // Perform variable substitution
        StringBuilder result = new StringBuilder();
        int startIndex = 0;
        while (startIndex < value.length()) {
            int startVar = value.indexOf("${", startIndex);
            if (startVar == -1) {
                result.append(value.substring(startIndex));
                break;
            }
            result.append(value.substring(startIndex, startVar));
            int endVar = value.indexOf("}", startVar);
            if (endVar == -1) {
                result.append(value.substring(startVar)); // No closing brace found
                break;
            }
            String varKey = value.substring(startVar + 2, endVar);
            String varValue = props.getProperty(varKey);
            if (varValue != null) {
                result.append(varValue);
            } else {
                result.append(value.substring(startVar, endVar + 1)); // Keep the variable as is
            }
            startIndex = endVar + 1;
        }

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
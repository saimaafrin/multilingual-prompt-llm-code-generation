import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertySubstitution {

    /**
     * <code>props</code> में <code>key</code> के अनुसार मान खोजें। फिर पाए गए मान पर वेरिएबल प्रतिस्थापन करें।
     */
    public static String findAndSubst(String key, Properties props) {
        // Get the value associated with the key from the properties
        String value = props.getProperty(key);
        if (value == null) {
            return null; // Return null if the key is not found
        }

        // Define a pattern to match variables in the format ${variable}
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);

        // Use StringBuffer to build the result with substitutions
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            // Extract the variable name from the match
            String variableName = matcher.group(1);
            // Get the value of the variable from the properties
            String variableValue = props.getProperty(variableName, "");
            // Replace the variable in the original string with its value
            matcher.appendReplacement(result, Matcher.quoteReplacement(variableValue));
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
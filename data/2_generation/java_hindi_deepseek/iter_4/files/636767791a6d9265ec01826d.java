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

        // Use a StringBuffer to build the result
        StringBuffer result = new StringBuffer();

        // Iterate through the matches and replace variables
        while (matcher.find()) {
            String variableKey = matcher.group(1);
            String variableValue = props.getProperty(variableKey);
            if (variableValue != null) {
                // Replace the variable with its value from the properties
                matcher.appendReplacement(result, Matcher.quoteReplacement(variableValue));
            } else {
                // If the variable is not found, leave it as is
                matcher.appendReplacement(result, Matcher.quoteReplacement(matcher.group(0)));
            }
        }
        matcher.appendTail(result);

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
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertySubstitution {

    public static String findAndSubst(String key, Properties props) {
        // Get the value associated with the key from the properties
        String value = props.getProperty(key);
        if (value == null) {
            return null; // Return null if the key is not found
        }

        // Define a pattern to match variables in the format ${variable}
        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        // Perform variable substitution
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
        props.setProperty("name", "John");
        props.setProperty("greeting", "Hello, ${name}!");

        String result = findAndSubst("greeting", props);
        System.out.println(result); // Output: Hello, John!
    }
}
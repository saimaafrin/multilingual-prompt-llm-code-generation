import java.util.Properties;

public class PropertySubstitution {

    /**
     * <code>props</code> में <code>key</code> के अनुसार मान खोजें। फिर पाए गए मान पर वेरिएबल प्रतिस्थापन करें।
     */
    public static String findAndSubst(String key, Properties props) {
        // Get the value associated with the key from the properties
        String value = props.getProperty(key);
        
        // If the value is null, return null
        if (value == null) {
            return null;
        }
        
        // Perform variable substitution on the value
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
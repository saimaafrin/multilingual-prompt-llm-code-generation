import java.util.Properties;

public class PropertyFinder {
    /** 
     * <code>props</code> में <code>key</code> के अनुसार मान खोजें। फिर पाए गए मान पर वेरिएबल प्रतिस्थापन करें।
     */
    public static String findAndSubst(String key, Properties props) {
        String value = props.getProperty(key);
        if (value == null) {
            return null; // या कोई डिफ़ॉल्ट मान लौटाएं
        }
        
        // वेरिएबल प्रतिस्थापन
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
        System.out.println(result); // "Hello, John!"
    }
}
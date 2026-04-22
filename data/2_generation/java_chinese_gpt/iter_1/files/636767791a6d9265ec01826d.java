import java.util.Properties;

public class VariableSubstitutor {

    /** 
     * 在 <code>props</code> 中查找与 <code>key</code> 对应的值。然后对找到的值进行变量替换。
     */
    public static String findAndSubst(String key, Properties props) {
        String value = props.getProperty(key);
        if (value == null) {
            return null;
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
                result.append(value.substring(startIndex));
                break;
            }
            String varKey = value.substring(startVar + 2, endVar);
            String varValue = props.getProperty(varKey);
            if (varValue != null) {
                result.append(varValue);
            } else {
                result.append("${").append(varKey).append("}");
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
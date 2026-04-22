import java.util.Properties;

public class VariableSubstitutor {

    /** 
     * 在 <code>props</code> 中查找与 <code>key</code> 对应的值。然后对找到的值进行变量替换。
     */
    public static String findAndSubst(String key, Properties props) {
        String value = props.getProperty(key);
        if (value == null) {
            return null; // 或者抛出异常，视需求而定
        }

        // 进行变量替换
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
        System.out.println(result); // 输出: Hello, John!
    }
}
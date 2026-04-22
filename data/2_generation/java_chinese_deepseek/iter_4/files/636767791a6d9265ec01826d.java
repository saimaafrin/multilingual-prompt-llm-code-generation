import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertySubstitutor {

    /**
     * 在 <code>props</code> 中查找与 <code>key</code> 对应的值。然后对找到的值进行变量替换。
     */
    public static String findAndSubst(String key, Properties props) {
        String value = props.getProperty(key);
        if (value == null) {
            return null;
        }

        // 正则表达式匹配 ${...} 形式的变量
        Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(value);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String varKey = matcher.group(1);
            String varValue = props.getProperty(varKey);
            if (varValue != null) {
                matcher.appendReplacement(result, varValue);
            } else {
                // 如果找不到对应的变量，保留原样
                matcher.appendReplacement(result, matcher.group(0));
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
        System.out.println(result);  // 输出: Hello, John!
    }
}
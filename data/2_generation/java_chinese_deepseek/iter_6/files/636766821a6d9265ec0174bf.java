import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    /**
     * Introspector.decapitalize 的反向操作
     */
    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return StringUtils.capitalize(name);
    }
}
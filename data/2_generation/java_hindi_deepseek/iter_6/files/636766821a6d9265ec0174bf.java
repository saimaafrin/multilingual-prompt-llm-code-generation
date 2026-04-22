import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return StringUtils.capitalize(name);
    }
}
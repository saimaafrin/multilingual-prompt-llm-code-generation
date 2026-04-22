import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    /**
     * Introspector.decapitalize का उल्टा
     * Capitalizes the first character of the given string.
     *
     * @param name the string to capitalize
     * @return the capitalized string
     */
    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return StringUtils.capitalize(name);
    }
}
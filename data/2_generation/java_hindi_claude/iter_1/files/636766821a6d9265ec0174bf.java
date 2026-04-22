import java.beans.Introspector;

public class StringUtils {

    /**
     * Reverse of Introspector.decapitalize
     * Capitalizes the first letter of a string, making the first character uppercase.
     * If the second character is uppercase, leaves the first character unchanged.
     * @param name The string to capitalize
     * @return The capitalized string
     */
    public static String capitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        if (name.length() > 1 && Character.isUpperCase(name.charAt(1))) {
            return name;
        }
        char chars[] = name.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }
}
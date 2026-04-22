package utils;

/**
 * String utility class containing capitalization methods
 */
public class StringUtils {

    /**
     * Performs the reverse operation of Introspector.decapitalize
     * Capitalizes the first character of the string if the second character is not already uppercase
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
package utils;

/**
 * Utility class for object conversions
 */
public class ObjectUtils {

    /**
     * Object to String, when null object then null else return toString()
     * @param object The object to convert to string
     * @return String representation of object, or null if object is null
     */
    public static String toString(Object object) {
        return object == null ? null : object.toString();
    }

}
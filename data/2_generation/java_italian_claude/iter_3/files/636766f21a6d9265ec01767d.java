package utils;

/**
 * Utility class for object conversions
 */
public class ObjectUtils {

    /**
     * Conversione da 'Object' a stringa, se l'oggetto è nullo allora restituisce null, altrimenti restituisce toString()
     * @param object The object to convert to string
     * @return String representation of the object, or null if object is null
     */
    public static String toString(Object object) {
        if (object == null) {
            return null;
        }
        return object.toString();
    }

}
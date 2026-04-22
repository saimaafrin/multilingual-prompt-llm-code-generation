/**
 * Converts an object to its string representation. If the object is null, returns null.
 * Otherwise, returns the result of the object's toString() method.
 *
 * @param object the object to convert to a string
 * @return the string representation of the object, or null if the object is null
 */
public static String toString(Object object) {
    return object == null ? null : object.toString();
}
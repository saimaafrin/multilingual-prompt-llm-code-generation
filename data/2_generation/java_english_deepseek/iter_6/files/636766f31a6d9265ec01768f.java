/**
 * Clones an array returning a typecast result and handling null.
 * This method returns null for a null input array.
 *
 * @param array the array to clone, may be null
 * @return the cloned array, null if null input
 */
public static char[] clone(final char[] array) {
    if (array == null) {
        return null;
    }
    return array.clone();
}
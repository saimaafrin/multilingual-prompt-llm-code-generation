/**
 * Clones an array returning a typecast result and handling <code>null</code>.
 * This method returns <code>null</code> for a <code>null</code> input array.
 *
 * @param array  the array to clone, may be <code>null</code>
 * @return the cloned array, <code>null</code> if <code>null</code> input
 */
public static char[] clone(final char[] array) {
    if (array == null) {
        return null;
    }
    return array.clone();
}
package org.apache.commons.lang3;

public class ArrayUtils {
    /**
     * <p>Clones an array returning a typecast result and handling <code>null</code>.</p>
     * <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
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
}
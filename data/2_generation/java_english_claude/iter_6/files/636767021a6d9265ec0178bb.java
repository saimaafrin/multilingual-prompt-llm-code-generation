package org.apache.commons.lang3;

/**
 * Utility class for handling arrays.
 */
public class ArrayUtils {

    /**
     * Empty array constant
     */
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];

    /**
     * <p>Defensive programming technique to change a <code>null</code> reference to an empty one.</p>
     * <p>This method returns an empty array for a <code>null</code> input array.</p>
     * <p>As a memory optimizing technique an empty array passed in will be overridden with the empty
     * <code>public static</code> references in this class.</p>
     *
     * @param array the array to check for <code>null</code> or empty
     * @return the same array, <code>public static</code> empty array if <code>null</code> or empty input
     * @since 2.5
     */
    public static Double[] nullToEmpty(final Double[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        return array;
    }
}
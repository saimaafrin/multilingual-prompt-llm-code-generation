package org.apache.commons.lang3;

/**
 * Utility class for array operations.
 */
public class ArrayUtils {

    /**
     * <p>Checks if an array of primitive doubles is empty or <code>null</code>.</p>
     * @param array  the array to test
     * @return <code>true</code> if the array is empty or <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(final double[] array) {
        return array == null || array.length == 0;
    }
}
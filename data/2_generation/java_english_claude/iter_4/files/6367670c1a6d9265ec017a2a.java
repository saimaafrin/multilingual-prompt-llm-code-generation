package org.apache.commons.lang3;

/**
 * Utility class for converting between primitive and wrapper arrays.
 */
public class ArrayUtils {

    /**
     * <p>Converts an array of object Integers to primitives.</p>
     * <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     *
     * @param array  a <code>Integer</code> array, may be <code>null</code>
     * @return an <code>int</code> array, <code>null</code> if null array input
     * @throws NullPointerException if array content is <code>null</code>
     */
    public static int[] toPrimitive(final Integer[] array) {
        if (array == null) {
            return null;
        }
        
        final int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].intValue();
        }
        return result;
    }
}
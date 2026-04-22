package org.apache.commons.lang3;

/**
 * Utility class for boolean array operations.
 */
public class BooleanUtils {

    /**
     * <p>Converts an array of primitive booleans to objects.</p>
     * <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * 
     * @param array  a <code>boolean</code> array
     * @return a <code>Boolean</code> array, <code>null</code> if null array input
     */
    public static Boolean[] toObject(final boolean[] array) {
        if (array == null) {
            return null;
        }
        
        final Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Boolean.valueOf(array[i]);
        }
        return result;
    }
}
package org.apache.commons.lang3;

public class ArrayUtils {
    /**
     * <p>Checks whether two arrays are the same length, treating <code>null</code> arrays as length <code>0</code>.</p>
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating<code>null</code> as an empty array
     */
    public static boolean isSameLength(final byte[] array1, final byte[] array2) {
        if (array1 == null && array2 == null) {
            return true;
        }
        if (array1 == null) {
            return array2.length == 0;
        }
        if (array2 == null) {
            return array1.length == 0;
        }
        return array1.length == array2.length;
    }
}
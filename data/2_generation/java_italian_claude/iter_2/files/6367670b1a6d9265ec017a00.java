package org.apache.commons.lang3;

public class ArrayUtils {
    /**
     * <p>Controlla se due array hanno la stessa lunghezza, trattando gli array <code>null</code> come lunghezza <code>0</code>.</p>
     * @param array1 il primo array, può essere <code>null</code>
     * @param array2 il secondo array, può essere <code>null</code>
     * @return <code>true</code> se la lunghezza degli array corrisponde, trattando <code>null</code> come un array vuoto
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
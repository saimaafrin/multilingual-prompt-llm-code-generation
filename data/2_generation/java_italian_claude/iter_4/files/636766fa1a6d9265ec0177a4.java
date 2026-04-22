package org.apache.commons.lang3;

/**
 * Utility class for converting primitive arrays to their corresponding object arrays.
 */
public class ArrayUtils {

    /**
     * <p>Converte un array di double primitivi in oggetti.</p>
     * <p>Questo metodo restituisce <code>null</code> per un array di input <code>null</code>.</p>
     * 
     * @param array  un array di <code>double</code>
     * @return un array di <code>Double</code>, <code>null</code> se l'array di input è null
     */
    public static Double[] toObject(final double[] array) {
        if (array == null) {
            return null;
        }
        
        final Double[] result = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Double.valueOf(array[i]);
        }
        return result;
    }
}
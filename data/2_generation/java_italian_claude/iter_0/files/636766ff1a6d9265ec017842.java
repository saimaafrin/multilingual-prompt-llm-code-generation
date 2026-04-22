package org.apache.commons.lang3;

/**
 * Utility class for converting between primitive and wrapper arrays
 */
public class ArrayUtils {

    /**
     * <p>Converte un array di oggetti Double in primitivi.</p>
     * <p>Questo metodo restituisce <code>null</code> per un array di input <code>null</code>.</p>
     * @param array  un array di <code>Double</code>, può essere <code>null</code>
     * @return un array di <code>double</code>, <code>null</code> se l'array di input è nullo
     * @throws NullPointerException se il contenuto dell'array è <code>null</code>
     */
    public static double[] toPrimitive(final Double[] array) {
        if (array == null) {
            return null;
        }
        
        final double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].doubleValue();
        }
        return result;
    }
}
package org.apache.commons.lang3;

/**
 * Utility class for converting primitive short arrays to Short object arrays.
 */
public class ShortUtils {

    /**
     * <p>Converte un array di short primitivi in oggetti.</p>
     * <p>Questo metodo restituisce <code>null</code> per un array di input <code>null</code>.</p>
     * 
     * @param array  un array di <code>short</code>
     * @return un array di <code>Short</code>, <code>null</code> se l'array di input è nullo
     */
    public static Short[] toObject(final short[] array) {
        if (array == null) {
            return null;
        }
        
        final Short[] result = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Short.valueOf(array[i]);
        }
        return result;
    }
}
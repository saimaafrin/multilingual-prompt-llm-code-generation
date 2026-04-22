package org.apache.commons.lang3;

/**
 * Utility class for converting primitive arrays to their object counterparts.
 */
public class ArrayUtils {

    /**
     * <p>Convierte un arreglo de primitivos "shorts" a objetos.</p>
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * 
     * @param array  un arreglo de <code>short</code>
     * @return un arreglo de <code>Short</code>, <code>null</code> si el arreglo de entrada es nulo
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
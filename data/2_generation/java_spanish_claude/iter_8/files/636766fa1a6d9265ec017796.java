package org.apache.commons.lang3;

/**
 * Utility class for boolean array operations.
 */
public class BooleanUtils {

    /**
     * <p>Convierte un arreglo de booleanos primitivos a objetos.</p>
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * 
     * @param array  un arreglo de <code>boolean</code>
     * @return un arreglo de <code>Boolean</code>, <code>null</code> si el arreglo de entrada es nulo
     */
    public static Boolean[] toObject(final boolean[] array) {
        if (array == null) {
            return null;
        }
        if (array.length == 0) {
            return new Boolean[0];
        }
        final Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Boolean.valueOf(array[i]);
        }
        return result;
    }
}
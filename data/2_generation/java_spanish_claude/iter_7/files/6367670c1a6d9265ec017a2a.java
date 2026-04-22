package org.apache.commons.lang3;

/**
 * Utility class for converting arrays of objects to arrays of primitives.
 */
public class ArrayUtils {

    /**
     * <p>Convierte un arreglo de objetos "Integer" a primitivos.</p>
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * 
     * @param array  un arreglo de <code>Integer</code>, puede ser <code>null</code>
     * @return un arreglo de <code>int</code>, <code>null</code> si el arreglo de entrada es nulo
     * @throws NullPointerException si el contenido del arreglo es <code>null</code>
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
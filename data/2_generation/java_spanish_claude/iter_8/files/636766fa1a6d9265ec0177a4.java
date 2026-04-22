package org.apache.commons.lang3;

/**
 * Utility class for converting primitive arrays to object arrays
 */
public class ArrayUtils {

    /**
     * <p>Convierte un arreglo de primitivos double a objetos.</p>
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  un arreglo de <code>double</code>
     * @return un arreglo de <code>Double</code>, <code>null</code> si el arreglo de entrada es nulo
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
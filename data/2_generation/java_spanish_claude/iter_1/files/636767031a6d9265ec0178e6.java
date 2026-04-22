package org.apache.commons.lang3;

/**
 * Utility class for converting between primitive and wrapper arrays
 */
public class ArrayUtils {

    /**
     * <p>Convierte un arreglo de objetos Byte a primitivos.</p>
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * 
     * @param array  un arreglo de <code>Byte</code>, puede ser <code>null</code>
     * @return un array de <code>byte</code>, <code>null</code> si el array de entrada es nulo
     * @throws NullPointerException si el contenido del array es <code>null</code>
     */
    public static byte[] toPrimitive(final Byte[] array) {
        if (array == null) {
            return null;
        }
        
        final byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].byteValue();
        }
        return result;
    }
}
package org.apache.commons.lang3;

/**
 * Utility class for converting between primitive and wrapper arrays.
 */
public class ArrayUtils {

    /**
     * <p>Converte un array di oggetti Byte in primitivi.</p>
     * <p>Questo metodo restituisce <code>null</code> per un array di input <code>null</code>.</p>
     * @param array  un array di <code>Byte</code>, può essere <code>null</code>
     * @return un array di <code>byte</code>, <code>null</code> se l'array di input è nullo
     * @throws NullPointerException se il contenuto dell'array è <code>null</code>
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
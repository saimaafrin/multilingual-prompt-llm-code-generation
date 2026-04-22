package org.apache.commons.lang3;

/**
 * Utility class for boolean operations.
 */
public class BooleanUtils {

    /**
     * <p>Converte un array di booleani primitivi in oggetti.</p>
     * <p>Questo metodo restituisce <code>null</code> per un array di input <code>null</code>.</p>
     * 
     * @param array  un array di <code>boolean</code>
     * @return un array di <code>Boolean</code>, <code>null</code> se l'array di input è null
     */
    public static Boolean[] toObject(final boolean[] array) {
        if (array == null) {
            return null;
        }
        
        final Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Boolean.valueOf(array[i]);
        }
        return result;
    }
}
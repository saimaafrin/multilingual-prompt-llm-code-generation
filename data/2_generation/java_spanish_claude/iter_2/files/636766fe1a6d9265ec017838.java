package org.apache.commons.lang3;

/**
 * Utility class for Character operations
 */
public class CharacterUtils {

    /**
     * <p>Convierte un array de objetos "Character" a primitivos.</p>
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  un arreglo de <code>Character</code>, puede ser <code>null</code>
     * @return un arreglo de <code>char</code>, <code>null</code> si el arreglo de entrada es nulo
     * @throws NullPointerException si el contenido del arreglo es <code>null</code>
     */
    public static char[] toPrimitive(final Character[] array) {
        if (array == null) {
            return null;
        }
        
        final char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].charValue();
        }
        return result;
    }
}
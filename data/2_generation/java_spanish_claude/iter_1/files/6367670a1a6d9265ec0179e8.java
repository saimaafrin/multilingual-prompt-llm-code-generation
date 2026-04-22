package org.apache.commons.lang3;

/**
 * Utility class for handling arrays.
 */
public class ArrayUtils {

    /**
     * Empty array constant used for optimization
     */
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];

    /**
     * <p>Técnica de programación defensiva para cambiar una referencia <code>null</code> por una vacía.</p>
     * <p>Este método devuelve un array vacío para un array de entrada <code>null</code>.</p>
     * <p>Como técnica de optimización de memoria, un array vacío pasado será reemplazado por las referencias vacías <code>public static</code> en esta clase.</p>
     * @param array  el array a verificar si es <code>null</code> o vacío
     * @return el mismo array, un array vacío <code>public static</code> si la entrada es <code>null</code> o vacía
     * @since 2.5
     */
    public static Boolean[] nullToEmpty(final Boolean[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        return array;
    }
}
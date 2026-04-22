package org.apache.commons.lang3;

/**
 * Utility class for array operations.
 */
public class ArrayUtils {

    /**
     * <p>Verifica si un arreglo de números decimales primitivos está vacío o es <code>null</code>.</p>
     * @param array  el arreglo a probar
     * @return <code>true</code> si el arreglo está vacío o es <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(final double[] array) {
        return array == null || array.length == 0;
    }

}
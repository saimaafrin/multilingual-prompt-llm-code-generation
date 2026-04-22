package org.apache.commons.lang3;

/**
 * Utility class for array operations.
 */
public class ArrayUtils {

    /**
     * <p>Controlla se un array di double primitivi è vuoto o <code>null</code>.</p>
     * @param array  l'array da testare
     * @return <code>true</code> se l'array è vuoto o <code>null</code>
     * @since 2.1
     */
    public static boolean isEmpty(final double[] array) {
        return array == null || array.length == 0;
    }
}
/**
 * Verifica si un arreglo de números decimales primitivos está vacío o es null.
 * @param array el arreglo a probar
 * @return true si el arreglo está vacío o es null
 * @since 2.1
 */
public static boolean isEmpty(final double[] array) {
    return array == null || array.length == 0;
}
/**
 * Verifica si un arreglo de números decimales primitivos está vacío o es <code>null</code>.
 * @param array  el arreglo a probar
 * @return <code>true</code> si el arreglo está vacío o es <code>null</code>
 * @since 2.1
 */
public static boolean isEmpty(final double[] array) {
    return array == null || array.length == 0;
}
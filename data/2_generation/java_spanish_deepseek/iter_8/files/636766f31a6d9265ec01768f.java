/**
 * Clona un arreglo devolviendo un resultado con tipo convertido y manejando <code>null</code>.
 * Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.
 *
 * @param array el arreglo a clonar, puede ser <code>null</code>
 * @return el arreglo clonado, <code>null</code> si la entrada es <code>null</code>
 */
public static char[] clone(final char[] array) {
    if (array == null) {
        return null;
    }
    return array.clone();
}
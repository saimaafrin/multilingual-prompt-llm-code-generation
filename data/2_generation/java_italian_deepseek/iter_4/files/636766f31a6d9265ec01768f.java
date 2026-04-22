/**
 * Clona un array restituendo un risultato di tipo cast e gestendo null.
 * Questo metodo restituisce null per un array di input null.
 *
 * @param array l'array da clonare, può essere null
 * @return l'array clonato, null se l'input è null
 */
public static char[] clone(final char[] array) {
    if (array == null) {
        return null;
    }
    return array.clone();
}
public class ArrayUtils {
    /**
     * <p>Clona un array restituendo un risultato di tipo cast e gestendo <code>null</code>.</p>
     * <p>Questo metodo restituisce <code>null</code> per un array di input <code>null</code>.</p>
     * 
     * @param array l'array da clonare, può essere <code>null</code>
     * @return l'array clonato, <code>null</code> se l'input è <code>null</code>
     */
    public static char[] clone(final char[] array) {
        if (array == null) {
            return null;
        }
        
        char[] result = new char[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        return result;
    }
}
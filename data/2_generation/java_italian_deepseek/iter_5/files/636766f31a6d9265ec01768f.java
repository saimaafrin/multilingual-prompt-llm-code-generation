public class ArrayUtils {

    /**
     * <p>Clona un array restituendo un risultato di tipo cast e gestendo <code>null</code>.</p>
     * <p>Questo metodo restituisce <code>null</code> per un array di input <code>null</code>.</p>
     * @param array  l'array da clonare, può essere <code>null</code>
     * @return l'array clonato, <code>null</code> se l'input è <code>null</code>
     */
    public static char[] clone(final char[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static void main(String[] args) {
        char[] original = {'a', 'b', 'c'};
        char[] cloned = clone(original);
        System.out.println("Original: " + java.util.Arrays.toString(original));
        System.out.println("Cloned: " + java.util.Arrays.toString(cloned));

        char[] nullArray = null;
        char[] clonedNull = clone(nullArray);
        System.out.println("Cloned null array: " + (clonedNull == null ? "null" : "not null"));
    }
}
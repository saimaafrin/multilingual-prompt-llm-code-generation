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
        char[] originalArray = {'a', 'b', 'c'};
        char[] clonedArray = clone(originalArray);
        System.out.println("Original Array: " + java.util.Arrays.toString(originalArray));
        System.out.println("Cloned Array: " + java.util.Arrays.toString(clonedArray));

        char[] nullArray = null;
        char[] clonedNullArray = clone(nullArray);
        System.out.println("Cloned Null Array: " + clonedNullArray);
    }
}
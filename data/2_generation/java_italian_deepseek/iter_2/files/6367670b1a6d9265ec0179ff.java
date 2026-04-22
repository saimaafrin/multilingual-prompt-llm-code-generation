import java.util.Objects;

public class DefensiveProgramming {

    // Array vuoto pubblico e statico per ottimizzazione della memoria
    public static final Byte[] EMPTY_BYTE_ARRAY = new Byte[0];

    /**
     * <p>Tecnica di programmazione difensiva per cambiare un riferimento <code>null</code> in uno vuoto.</p>
     * <p>Questo metodo restituisce un array vuoto per un array di input <code>null</code>.</p>
     * <p>Come tecnica di ottimizzazione della memoria, un array vuoto passato verrà sovrascritto con i riferimenti vuoti <code>public static</code> in questa classe.</p>
     * @param array  l'array da controllare per <code>null</code> o vuoto
     * @return lo stesso array, array vuoto <code>public static</code> se l'input è <code>null</code> o vuoto
     * @since 2.5
     */
    public static Byte[] nullToEmpty(final Byte[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        // Test cases
        Byte[] nullArray = null;
        Byte[] emptyArray = new Byte[0];
        Byte[] nonEmptyArray = {1, 2, 3};

        System.out.println(Objects.toString(nullToEmpty(nullArray)));    // Output: []
        System.out.println(Objects.toString(nullToEmpty(emptyArray)));  // Output: []
        System.out.println(Objects.toString(nullToEmpty(nonEmptyArray))); // Output: [1, 2, 3]
    }
}
import java.util.Arrays;

public class DefensiveProgramming {

    // Array vuoto pubblico e statico per ottimizzazione della memoria
    public static final Boolean[] EMPTY_BOOLEAN_ARRAY = new Boolean[0];

    /**
     * <p>Tecnica di programmazione difensiva per cambiare un riferimento <code>null</code> in uno vuoto.</p>
     * <p>Questo metodo restituisce un array vuoto per un array di input <code>null</code>.</p>
     * <p>Come tecnica di ottimizzazione della memoria, un array vuoto passato verrà sovrascritto con i riferimenti vuoti <code>public static</code> in questa classe.</p>
     * @param array  l'array da controllare per <code>null</code> o vuoto
     * @return lo stesso array, array vuoto <code>public static</code> se l'input è <code>null</code> o vuoto
     * @since 2.5
     */
    public static Boolean[] nullToEmpty(final Boolean[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        // Test cases
        Boolean[] nullArray = null;
        Boolean[] emptyArray = new Boolean[0];
        Boolean[] nonEmptyArray = { true, false, true };

        System.out.println(Arrays.toString(nullToEmpty(nullArray)));    // Output: []
        System.out.println(Arrays.toString(nullToEmpty(emptyArray)));  // Output: []
        System.out.println(Arrays.toString(nullToEmpty(nonEmptyArray))); // Output: [true, false, true]
    }
}
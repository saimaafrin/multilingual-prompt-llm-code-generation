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

    // Esempio di utilizzo
    public static void main(String[] args) {
        Boolean[] array1 = null;
        Boolean[] array2 = new Boolean[0];
        Boolean[] array3 = {true, false, true};

        System.out.println(nullToEmpty(array1) == EMPTY_BOOLEAN_ARRAY); // true
        System.out.println(nullToEmpty(array2) == EMPTY_BOOLEAN_ARRAY); // true
        System.out.println(nullToEmpty(array3) == array3); // true
    }
}
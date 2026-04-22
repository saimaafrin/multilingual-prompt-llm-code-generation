public class DefensiveProgramming {

    // Array vuoto pubblico e statico per ottimizzazione della memoria
    public static final Character[] EMPTY_CHARACTER_ARRAY = new Character[0];

    /**
     * <p>Tecnica di programmazione difensiva per cambiare un riferimento <code>null</code> in uno vuoto.</p>
     * <p>Questo metodo restituisce un array vuoto per un array di input <code>null</code>.</p>
     * <p>Come tecnica di ottimizzazione della memoria, un array vuoto passato verrà sovrascritto con i riferimenti vuoti <code>public static</code> in questa classe.</p>
     * @param array  l'array da controllare per <code>null</code> o vuoto
     * @return lo stesso array, array vuoto <code>public static</code> se l'input è <code>null</code> o vuoto
     * @since 2.5
     */
    public static Character[] nullToEmpty(final Character[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_CHARACTER_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        // Test del metodo
        Character[] nullArray = null;
        Character[] emptyArray = new Character[0];
        Character[] nonEmptyArray = {'a', 'b', 'c'};

        System.out.println(nullToEmpty(nullArray) == EMPTY_CHARACTER_ARRAY); // true
        System.out.println(nullToEmpty(emptyArray) == EMPTY_CHARACTER_ARRAY); // true
        System.out.println(nullToEmpty(nonEmptyArray) == nonEmptyArray); // true
    }
}
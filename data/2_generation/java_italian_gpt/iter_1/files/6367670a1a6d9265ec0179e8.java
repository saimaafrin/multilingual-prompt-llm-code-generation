public class DefensiveProgramming {

    private static final Boolean[] EMPTY_ARRAY = new Boolean[0];

    /** 
     * <p>Tecnica di programmazione difensiva per cambiare un riferimento <code>null</code> in uno vuoto.</p> 
     * <p>Questo metodo restituisce un array vuoto per un array di input <code>null</code>.</p> 
     * <p>Come tecnica di ottimizzazione della memoria, un array vuoto passato verrà sovrascritto con i riferimenti vuoti <code>public static</code> in questa classe.</p>
     * @param array  l'array da controllare per <code>null</code> o vuoto
     * @return lo stesso array, array vuoto <code>public static</code> se l'input è <code>null</code> o vuoto
     * @since 2.5
     */
    public static Boolean[] nullToEmpty(final Boolean[] array) {
        return (array == null || array.length == 0) ? EMPTY_ARRAY : array;
    }

    public static void main(String[] args) {
        // Test cases
        Boolean[] testArray1 = null;
        Boolean[] testArray2 = {};
        Boolean[] testArray3 = {true, false};

        System.out.println(nullToEmpty(testArray1).length); // Output: 0
        System.out.println(nullToEmpty(testArray2).length); // Output: 0
        System.out.println(nullToEmpty(testArray3).length); // Output: 2
    }
}
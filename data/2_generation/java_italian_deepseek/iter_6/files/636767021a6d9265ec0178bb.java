public class ArrayUtils {

    // Array vuoto pubblico e statico per ottimizzazione della memoria
    public static final Double[] EMPTY_DOUBLE_ARRAY = new Double[0];

    /**
     * <p>Tecnica di programmazione difensiva per cambiare un riferimento <code>null</code> in uno vuoto.</p>
     * <p>Questo metodo restituisce un array vuoto per un array di input <code>null</code>.</p>
     * <p>Come tecnica di ottimizzazione della memoria, un array vuoto passato verrà sovrascritto con i riferimenti vuoti <code>public static</code> in questa classe.</p>
     * @param array  l'array da controllare per <code>null</code> o vuoto
     * @return lo stesso array, array vuoto <code>public static</code> se l'input è <code>null</code> o vuoto
     * @since 2.5
     */
    public static Double[] nullToEmpty(final Double[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        return array;
    }

    // Esempio di utilizzo
    public static void main(String[] args) {
        Double[] array1 = null;
        Double[] array2 = new Double[0];
        Double[] array3 = {1.0, 2.0, 3.0};

        System.out.println(nullToEmpty(array1) == EMPTY_DOUBLE_ARRAY); // true
        System.out.println(nullToEmpty(array2) == EMPTY_DOUBLE_ARRAY); // true
        System.out.println(nullToEmpty(array3) == array3); // true
    }
}
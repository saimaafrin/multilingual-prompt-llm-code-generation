public class DefensiveProgramming {

    private static final Double[] EMPTY_ARRAY = new Double[0];

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
            return EMPTY_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        Double[] result1 = nullToEmpty(null);
        System.out.println("Result 1: " + (result1.length == 0 ? "Empty Array" : "Not Empty"));

        Double[] result2 = nullToEmpty(new Double[]{});
        System.out.println("Result 2: " + (result2.length == 0 ? "Empty Array" : "Not Empty"));

        Double[] result3 = nullToEmpty(new Double[]{1.0, 2.0, 3.0});
        System.out.println("Result 3: " + (result3.length == 0 ? "Empty Array" : "Not Empty"));
    }
}
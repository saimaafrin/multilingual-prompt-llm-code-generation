public class DefensiveProgramming {

    private static final Character[] EMPTY_ARRAY = new Character[0];

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
            return EMPTY_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        Character[] result1 = nullToEmpty(null);
        Character[] result2 = nullToEmpty(new Character[]{});
        Character[] result3 = nullToEmpty(new Character[]{'a', 'b', 'c'});

        System.out.println("Result 1: " + (result1.length == 0 ? "Empty Array" : "Not Empty"));
        System.out.println("Result 2: " + (result2.length == 0 ? "Empty Array" : "Not Empty"));
        System.out.println("Result 3: " + (result3.length == 0 ? "Empty Array" : "Not Empty"));
    }
}
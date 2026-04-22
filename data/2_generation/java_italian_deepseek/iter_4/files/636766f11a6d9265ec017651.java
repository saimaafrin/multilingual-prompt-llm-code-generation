import java.util.Objects;

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

    // Esempio di utilizzo
    public static void main(String[] args) {
        Character[] array1 = null;
        Character[] array2 = new Character[0];
        Character[] array3 = new Character[]{'a', 'b', 'c'};

        System.out.println(Objects.toString(nullToEmpty(array1))); // []
        System.out.println(Objects.toString(nullToEmpty(array2))); // []
        System.out.println(Objects.toString(nullToEmpty(array3))); // [a, b, c]
    }
}
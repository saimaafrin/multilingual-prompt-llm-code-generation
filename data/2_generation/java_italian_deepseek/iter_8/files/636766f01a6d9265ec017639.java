import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {

    /**
     * Array in Lista. <p> Funziona come {@link Arrays#asList(Object)}, ma gestisce gli array nulli.
     * @param a l'array da convertire in lista
     * @return una lista supportata dall'array. Se l'array è null, restituisce una lista vuota.
     */
    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(Arrays.asList(a));
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        String[] array = {"uno", "due", "tre"};
        List<String> lista = asList(array);
        System.out.println(lista); // Output: [uno, due, tre]

        String[] nullArray = null;
        List<String> nullList = asList(nullArray);
        System.out.println(nullList); // Output: []
    }
}
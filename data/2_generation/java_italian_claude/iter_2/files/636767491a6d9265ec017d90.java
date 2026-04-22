import java.util.Objects;

public class ArrayUtils {
    /**
     * Inverte l'ordine degli elementi nell'intervallo specificato all'interno dell'array fornito.
     * @param <V> il tipo di elementi nell'array
     * @param arr l'array
     * @param from l'indice del primo elemento (inclusivo) all'interno dell'intervallo da invertire
     * @param to l'indice dell'ultimo elemento (inclusivo) all'interno dell'intervallo da invertire
     */
    public static final <V> void reverse(V[] arr, int from, int to) {
        // Check for null array
        Objects.requireNonNull(arr, "Array cannot be null");
        
        // Validate indices
        if (from < 0 || to >= arr.length || from > to) {
            throw new IllegalArgumentException("Invalid range indices");
        }
        
        // Reverse elements in the specified range
        while (from < to) {
            // Swap elements
            V temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            
            // Move indices towards center
            from++;
            to--;
        }
    }
}
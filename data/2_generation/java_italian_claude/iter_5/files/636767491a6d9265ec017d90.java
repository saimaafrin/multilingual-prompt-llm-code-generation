import java.util.Arrays;

public class ArrayUtils {
    /**
     * Inverte l'ordine degli elementi nell'intervallo specificato all'interno dell'array fornito.
     * @param <V> il tipo di elementi nell'array
     * @param arr l'array
     * @param from l'indice del primo elemento (inclusivo) all'interno dell'intervallo da invertire
     * @param to l'indice dell'ultimo elemento (inclusivo) all'interno dell'intervallo da invertire
     */
    public static final <V> void reverse(V[] arr, int from, int to) {
        if (arr == null || arr.length == 0) {
            return;
        }
        
        if (from < 0 || to >= arr.length || from > to) {
            throw new IllegalArgumentException("Invalid range parameters");
        }
        
        while (from < to) {
            // Swap elements
            V temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            
            from++;
            to--;
        }
    }
}
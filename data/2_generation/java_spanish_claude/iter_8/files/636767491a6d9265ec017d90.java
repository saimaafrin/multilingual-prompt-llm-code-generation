public class ArrayUtils {
    /**
     * Invierte el orden de los elementos en el rango especificado dentro del arreglo dado.
     * @param <V> el tipo de elementos en el arreglo
     * @param arr el arreglo
     * @param from el índice del primer elemento (inclusive) dentro del rango a invertir
     * @param to el índice del último elemento (inclusive) dentro del rango a invertir
     */
    public static final <V> void reverse(V[] arr, int from, int to) {
        while (from < to) {
            V temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to--;
        }
    }
}
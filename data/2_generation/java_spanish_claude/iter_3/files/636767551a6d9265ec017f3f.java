public class ArrayUtils {
    /**
     * Intercambia los dos elementos en los índices especificados en el arreglo dado.
     * @param <V> el tipo de elementos en el arreglo
     * @param arr el arreglo
     * @param i el índice del primer elemento
     * @param j el índice del segundo elemento
     */
    public static final <V> void swap(V[] arr, int i, int j) {
        V temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
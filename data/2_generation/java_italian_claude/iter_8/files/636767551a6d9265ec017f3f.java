public class ArrayUtils {
    /**
     * Scambia i due elementi agli indici specificati nell'array fornito.
     * @param <V> il tipo di elementi nell'array
     * @param arr l'array
     * @param i l'indice del primo elemento
     * @param j l'indice del secondo elemento
     */
    public static final <V> void swap(V[] arr, int i, int j) {
        V temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
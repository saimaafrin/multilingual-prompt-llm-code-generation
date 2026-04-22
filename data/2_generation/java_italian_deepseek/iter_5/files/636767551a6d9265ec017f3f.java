public class ArrayUtils {
    /**
     * Scambia i due elementi agli indici specificati nell'array fornito.
     * @param <V> il tipo di elementi nell'array
     * @param arr l'array
     * @param i l'indice del primo elemento
     * @param j l'indice del secondo elemento
     */
    public static final <V> void swap(V[] arr, int i, int j) {
        if (arr == null || i < 0 || j < 0 || i >= arr.length || j >= arr.length) {
            throw new IllegalArgumentException("Indici non validi o array nullo");
        }
        V temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        Integer[] array = {1, 2, 3, 4, 5};
        System.out.println("Array prima dello scambio: " + java.util.Arrays.toString(array));
        swap(array, 1, 3);
        System.out.println("Array dopo lo scambio: " + java.util.Arrays.toString(array));
    }
}
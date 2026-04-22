public class ArrayUtils {
    /**
     * Swaps the two elements at the specified indices in the given array.
     * @param <V> the type of elements in the array
     * @param arr the array
     * @param i the index of the first element
     * @param j the index of the second element
     */
    public static final <V> void swap(V[] arr, int i, int j) {
        V temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
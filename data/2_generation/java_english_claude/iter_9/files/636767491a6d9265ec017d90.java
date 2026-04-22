import java.util.Objects;

public class ArrayUtils {
    /**
     * Reverses the order of the elements in the specified range within the given array.
     * @param <V> the type of elements in the array
     * @param arr the array
     * @param from the index of the first element (inclusive) inside the range to reverse
     * @param to the index of the last element (inclusive) inside the range to reverse
     */
    public static final <V> void reverse(V[] arr, int from, int to) {
        // Input validation
        Objects.requireNonNull(arr, "Array cannot be null");
        if (from < 0 || to >= arr.length || from > to) {
            throw new IllegalArgumentException("Invalid range specified");
        }

        // Reverse elements in the range
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
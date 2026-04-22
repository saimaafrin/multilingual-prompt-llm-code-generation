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
        Objects.requireNonNull(arr, "The input array must not be null.");
        if (from < 0 || to >= arr.length || from > to) {
            throw new IllegalArgumentException("Invalid range: from=" + from + ", to=" + to);
        }

        while (from < to) {
            V temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to--;
        }
    }

    public static void main(String[] args) {
        // Example usage
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        reverse(array, 2, 5);
        for (Integer num : array) {
            System.out.print(num + " ");
        }
        // Output: 1 2 6 5 4 3 7
    }
}
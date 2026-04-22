public class ArrayUtils {

    /**
     * Swaps the two elements at the specified indices in the given array.
     * @param <V> the type of elements in the array
     * @param arr the array
     * @param i the index of the first element
     * @param j the index of the second element
     */
    public static final <V> void swap(V[] arr, int i, int j) {
        if (arr == null || i < 0 || j < 0 || i >= arr.length || j >= arr.length) {
            throw new IllegalArgumentException("Invalid array or indices");
        }
        V temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Example usage
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Before swap: " + java.util.Arrays.toString(numbers));
        swap(numbers, 1, 3);
        System.out.println("After swap: " + java.util.Arrays.toString(numbers));
    }
}
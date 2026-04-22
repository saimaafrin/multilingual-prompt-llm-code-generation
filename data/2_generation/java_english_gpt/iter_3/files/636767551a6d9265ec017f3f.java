public class ArrayUtils {
    /** 
     * Swaps the two elements at the specified indices in the given array.
     * @param < V > the type of elements in the array
     * @param arr the array
     * @param i the index of the first element
     * @param j the index of the second element
     */
    public static final <V> void swap(V[] arr, int i, int j) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        V temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        System.out.println("Before swap: " + java.util.Arrays.toString(array));
        swap(array, 1, 3);
        System.out.println("After swap: " + java.util.Arrays.toString(array));
    }
}
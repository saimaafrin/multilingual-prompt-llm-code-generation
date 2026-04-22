public class ArrayReverser {
    /** 
     * Reverses the order of the elements in the specified range within the given array.
     * @param < V > the type of elements in the array
     * @param arr the array
     * @param from the index of the first element (inclusive) inside the range to reverse
     * @param to the index of the last element (inclusive) inside the range to reverse
     */
    public static final <V> void reverse(V[] arr, int from, int to) {
        if (arr == null || from < 0 || to >= arr.length || from >= to) {
            throw new IllegalArgumentException("Invalid range or array");
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
        Integer[] array = {1, 2, 3, 4, 5};
        reverse(array, 1, 3);
        for (Integer num : array) {
            System.out.print(num + " ");
        }
    }
}
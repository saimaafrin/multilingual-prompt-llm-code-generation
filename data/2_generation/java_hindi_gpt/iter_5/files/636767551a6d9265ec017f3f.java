public class ArrayUtils {
    /** 
     * दिए गए ऐरे में निर्दिष्ट अनुक्रमांक पर दो तत्वों का आदान-प्रदान करता है।
     * @param < V > ऐरे में तत्वों का प्रकार
     * @param arr ऐरे
     * @param i पहले तत्व का अनुक्रमांक
     * @param j दूसरे तत्व का अनुक्रमांक
     */
    public static final <V> void swap(V[] arr, int i, int j) {
        if (arr == null || i < 0 || j < 0 || i >= arr.length || j >= arr.length) {
            throw new IllegalArgumentException("Invalid index or null array");
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
public class ArrayReverser {
    /** 
     * निर्दिष्ट सीमा के भीतर दिए गए ऐरे में तत्वों के क्रम को उलटता है।
     * @param < V > ऐरे में तत्वों का प्रकार
     * @param arr ऐरे
     * @param from उलटने के लिए सीमा के भीतर पहले तत्व का अनुक्रमांक (समावेशी)
     * @param to उलटने के लिए सीमा के भीतर अंतिम तत्व का अनुक्रमांक (समावेशी)
     */
    public static final <V> void reverse(V[] arr, int from, int to) {
        if (arr == null || from < 0 || to >= arr.length || from >= to) {
            throw new IllegalArgumentException("Invalid indices or null array");
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
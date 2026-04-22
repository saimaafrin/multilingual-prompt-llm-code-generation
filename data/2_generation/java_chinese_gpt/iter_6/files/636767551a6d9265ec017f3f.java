public class ArrayUtils {
    /**
     * 交换给定数组中指定索引的两个元素。
     * @param <V> 数组中元素的类型
     * @param arr 数组
     * @param i 第一个元素的索引
     * @param j 第二个元素的索引
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
        swap(array, 1, 3);
        for (Integer num : array) {
            System.out.print(num + " ");
        }
    }
}
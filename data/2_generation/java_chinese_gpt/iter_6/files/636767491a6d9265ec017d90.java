public class ArrayReverser {
    /** 
     * 反转给定数组中指定范围内元素的顺序。
     * @param <V> 数组中元素的类型
     * @param arr 数组
     * @param from 要反转的范围内第一个元素的索引（包含）
     * @param to 要反转的范围内最后一个元素的索引（包含）
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
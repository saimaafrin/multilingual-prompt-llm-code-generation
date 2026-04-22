import java.lang.reflect.Array;

public class ArrayUtils {

    /**
     * 返回给定数组的副本，大小比参数大1。数组的最后一个值保留为默认值。
     * @param array 要复制的数组，不能为 <code>null</code>。
     * @param newArrayComponentType 如果 <code>array</code> 为 <code>null</code>，则创建一个该类型的大小为1的数组。
     * @return 一个新复制的数组，大小比输入数组大1。
     */
    private static Object copyArrayGrow1(final Object array, final Class<?> newArrayComponentType) {
        if (array == null) {
            return Array.newInstance(newArrayComponentType, 1);
        }

        int length = Array.getLength(array);
        Object newArray = Array.newInstance(array.getClass().getComponentType(), length + 1);
        System.arraycopy(array, 0, newArray, 0, length);
        return newArray;
    }

    public static void main(String[] args) {
        // Example usage
        int[] originalArray = {1, 2, 3};
        int[] newArray = (int[]) copyArrayGrow1(originalArray, int.class);
        System.out.println("Original array length: " + originalArray.length);
        System.out.println("New array length: " + newArray.length);
    }
}
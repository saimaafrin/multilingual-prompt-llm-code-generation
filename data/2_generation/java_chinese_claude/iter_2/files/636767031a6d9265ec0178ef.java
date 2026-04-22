import java.lang.reflect.Array;

public class ArrayUtils {

    /**
     * 返回给定数组的副本，大小比参数大1。数组的最后一个值保留为默认值。
     * @param array 要复制的数组，不能为 <code>null</code>。
     * @param newArrayComponentType 如果 <code>array</code> 为 <code>null</code>，则创建一个该类型的大小为1的数组。
     * @return 一个新复制的数组，大小比输入数组大1。
     */
    private static Object copyArrayGrow1(final Object array, final Class<?> newArrayComponentType) {
        if (array != null) {
            int arrayLength = Array.getLength(array);
            Object newArray = Array.newInstance(array.getClass().getComponentType(), arrayLength + 1);
            System.arraycopy(array, 0, newArray, 0, arrayLength);
            return newArray;
        }
        return Array.newInstance(newArrayComponentType, 1);
    }
}
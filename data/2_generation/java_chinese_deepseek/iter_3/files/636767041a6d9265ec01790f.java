import java.util.Objects;

public class ArrayConverter {

    /**
     * <p>将基本数据类型的 int 数组转换为对象类型。</p> <p>对于输入数组 <code>null</code>，此方法返回 <code>null</code>。</p>
     * @param array  一个 <code>int</code> 数组
     * @return 一个 <code>Integer</code> 数组，如果输入数组为空则返回 <code>null</code>
     */
    public static Integer[] toObject(final int[] array) {
        if (array == null) {
            return null;
        }
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};
        Integer[] integerArray = toObject(intArray);
        for (Integer num : integerArray) {
            System.out.println(num);
        }
    }
}
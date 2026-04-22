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
            result[i] = Integer.valueOf(array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] primitiveArray = {1, 2, 3, 4, 5};
        Integer[] objectArray = toObject(primitiveArray);
        for (Integer num : objectArray) {
            System.out.println(num);
        }
    }
}
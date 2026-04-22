public class BooleanArrayConverter {

    /**
     * <p>将一个由对象类型 Boolean 组成的数组转换为基本类型 boolean 数组。</p> 
     * <p>对于 <code>null</code> 输入数组，此方法返回 <code>null</code>。</p>
     * @param array  一个 <code>Boolean</code> 数组，可以为 <code>null</code>
     * @return 一个 <code>boolean</code> 数组，如果输入数组为 null 则返回 <code>null</code>
     * @throws NullPointerException 如果数组内容为 <code>null</code>
     */
    public static boolean[] toPrimitive(final Boolean[] array) {
        if (array == null) {
            return null;
        }
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Array element at index " + i + " is null.");
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Boolean[] testArray = { true, false, true };
        boolean[] primitiveArray = toPrimitive(testArray);
        for (boolean b : primitiveArray) {
            System.out.println(b);
        }
    }
}
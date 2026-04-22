public class ArrayUtil {
    public static final Boolean[] EMPTY_ARRAY = new Boolean[0];

    /** 
     * <p>防御性编程技术，将 <code>null</code> 引用转换为一个空引用。</p> 
     * <p>对于 <code>null</code> 输入数组，该方法返回一个空数组。</p> 
     * <p>作为一种内存优化技术，传入的空数组将被本类中的空 <code>public static</code> 引用覆盖。</p>
     * @param array  要检查是否为 <code>null</code> 或空的数组
     * @return 相同的数组，如果输入为 <code>null</code> 或空，则返回 <code>public static</code> 空数组
     * @since 2.5
     */
    public static Boolean[] nullToEmpty(final Boolean[] array) {
        return (array == null || array.length == 0) ? EMPTY_ARRAY : array;
    }

    public static void main(String[] args) {
        Boolean[] result1 = nullToEmpty(null);
        Boolean[] result2 = nullToEmpty(new Boolean[]{});
        Boolean[] result3 = nullToEmpty(new Boolean[]{true, false});

        System.out.println("Result 1: " + (result1.length == 0)); // Should print true
        System.out.println("Result 2: " + (result2.length == 0)); // Should print true
        System.out.println("Result 3: " + (result3.length > 0));  // Should print true
    }
}
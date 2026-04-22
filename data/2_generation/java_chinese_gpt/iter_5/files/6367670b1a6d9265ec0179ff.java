public class ArrayUtil {
    public static final Byte[] EMPTY_BYTE_ARRAY = new Byte[0];

    /** 
     * <p>防御性编程技术，将 <code>null</code> 引用转换为一个空引用。</p> 
     * <p>对于 <code>null</code> 输入数组，该方法返回一个空数组。</p> 
     * <p>作为一种内存优化技术，传入的空数组将被本类中的空 <code>public static</code> 引用覆盖。</p>
     * @param array  要检查是否为 <code>null</code> 或空的数组
     * @return 相同的数组，如果输入为 <code>null</code> 或空，则返回 <code>public static</code> 空数组
     * @since 2.5
     */
    public static Byte[] nullToEmpty(final Byte[] array) {
        return (array == null || array.length == 0) ? EMPTY_BYTE_ARRAY : array;
    }

    public static void main(String[] args) {
        Byte[] result1 = nullToEmpty(null);
        Byte[] result2 = nullToEmpty(new Byte[]{});
        Byte[] result3 = nullToEmpty(new Byte[]{1, 2, 3});

        System.out.println("Result 1: " + (result1.length == 0 ? "Empty Array" : "Not Empty"));
        System.out.println("Result 2: " + (result2.length == 0 ? "Empty Array" : "Not Empty"));
        System.out.println("Result 3: " + (result3.length == 0 ? "Empty Array" : "Not Empty"));
    }
}
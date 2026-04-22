public class ArrayUtils {
    /**
     * <p>克隆一个数组，返回类型转换的结果并能处理 <code>null</code>。</p>
     * <p>对于 <code>null</code> 输入数组，此方法返回 <code>null</code>。</p>
     * @param array 要克隆的数组，可以是 <code>null</code>
     * @return 克隆后的数组，如果输入为 <code>null</code> 则返回 <code>null</code>
     */
    public static char[] clone(final char[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }
}
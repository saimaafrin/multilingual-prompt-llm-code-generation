package org.apache.commons.lang3;

/**
 * Utility class for handling arrays.
 */
public class ArrayUtils {

    /**
     * Empty array constant used for memory optimization
     */
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];

    /**
     * <p>防御性编程技术，将 <code>null</code> 引用转换为一个空引用。</p>
     * <p>对于 <code>null</code> 输入数组，该方法返回一个空数组。</p>
     * <p>作为一种内存优化技术，传入的空数组将被本类中的空 <code>public static</code> 引用覆盖。</p>
     *
     * @param array 要检查是否为 <code>null</code> 或空的数组
     * @return 相同的数组，如果输入为 <code>null</code> 或空，则返回 <code>public static</code> 空数组
     * @since 2.5
     */
    public static Byte[] nullToEmpty(final Byte[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        return array;
    }
}
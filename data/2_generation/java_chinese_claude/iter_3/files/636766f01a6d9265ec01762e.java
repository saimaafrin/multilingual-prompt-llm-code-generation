package org.apache.commons.lang3;

/**
 * Utility class for array operations
 */
public class ArrayUtils {

    /**
     * <p>检查一个原始双精度数组是否为空或<code>null</code>。</p>
     * @param array  要测试的数组
     * @return 如果数组为空或<code>null</code>则返回<code>true</code>
     * @since 2.1
     */
    public static boolean isEmpty(final double[] array) {
        return array == null || array.length == 0;
    }

}
package org.apache.commons.lang3;

/**
 * ArrayUtils class containing array manipulation methods.
 */
public class ArrayUtils {

    /**
     * <p>检查两个数组是否具有相同的长度，将 <code>null</code> 数组视为长度 <code>0</code>。</p>
     * @param array1 第一个数组，可以为 <code>null</code>
     * @param array2 第二个数组，可以为 <code>null</code>
     * @return 如果数组的长度匹配则返回<code>true</code>，将 <code>null</code> 视为一个空数组
     */
    public static boolean isSameLength(final byte[] array1, final byte[] array2) {
        if (array1 == null && array2 == null) {
            return true;
        }
        if (array1 == null) {
            return array2.length == 0;
        }
        if (array2 == null) {
            return array1.length == 0;
        }
        return array1.length == array2.length;
    }
}
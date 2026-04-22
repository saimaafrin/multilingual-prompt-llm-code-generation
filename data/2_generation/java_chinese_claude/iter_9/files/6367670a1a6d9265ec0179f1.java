package org.example;

/**
 * Utility class for array conversions
 */
public class ArrayUtils {

    /**
     * <p>将基本数据类型的 short 数组转换为对象类型。</p> 
     * <p>对于 <code>null</code> 输入数组，此方法返回 <code>null</code>。</p>
     * 
     * @param array  一个 <code>short</code> 数组
     * @return 一个 <code>Short</code> 数组，如果输入数组为空则返回 <code>null</code>
     */
    public static Short[] toObject(final short[] array) {
        if (array == null) {
            return null;
        }
        
        final Short[] result = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Short.valueOf(array[i]);
        }
        return result;
    }
}
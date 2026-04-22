package org.apache.commons.lang3;

/**
 * Utility class for handling Double arrays.
 */
public class DoubleUtils {

    /**
     * <p>将对象类型的 Double 数组转换为基本数据类型的 double 数组。</p>
     * <p>如果输入数组为 <code>null</code>，则此方法返回 <code>null</code>。</p>
     * @param array 一个 <code>Double</code> 数组，可以为 <code>null</code>
     * @return 一个 <code>double</code> 数组，如果输入数组为空则返回 <code>null</code>
     * @throws NullPointerException 如果数组内容为 <code>null</code>
     */
    public static double[] toPrimitive(final Double[] array) {
        if (array == null) {
            return null;
        }
        
        final double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].doubleValue();
        }
        return result;
    }
}
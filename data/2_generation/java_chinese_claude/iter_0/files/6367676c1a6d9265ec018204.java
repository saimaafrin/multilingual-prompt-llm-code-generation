public class ArrayUtils {
    /**
     * 将给定的字符串数组连接成一个数组，重复的数组元素也会包含在内。<p>原始数组中的元素顺序得以保留。
     * @param array1 第一个数组（可以为<code>null</code>）
     * @param array2 第二个数组（可以为<code>null</code>）
     * @return 新数组（如果两个给定数组都为<code>null</code>，则返回<code>null</code>）
     */
    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        // 如果两个数组都为null,返回null
        if (array1 == null && array2 == null) {
            return null;
        }
        
        // 如果array1为null,返回array2的副本
        if (array1 == null) {
            return array2.clone();
        }
        
        // 如果array2为null,返回array1的副本
        if (array2 == null) {
            return array1.clone();
        }
        
        // 创建新数组存储连接结果
        String[] result = new String[array1.length + array2.length];
        
        // 复制array1到结果数组
        System.arraycopy(array1, 0, result, 0, array1.length);
        
        // 复制array2到结果数组
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        
        return result;
    }
}
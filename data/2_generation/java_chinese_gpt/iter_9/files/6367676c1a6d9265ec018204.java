public class StringArrayConcatenator {

    /**
     * 将给定的字符串数组连接成一个数组，重复的数组元素也会包含在内。<p>原始数组中的元素顺序得以保留。
     * @param array1 第一个数组（可以为<code>null</code>）
     * @param array2 第二个数组（可以为<code>null</code>）
     * @return 新数组（如果两个给定数组都为<code>null</code>，则返回<code>null</code>）
     */
    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        if (array1 == null && array2 == null) {
            return null;
        }

        int length1 = (array1 != null) ? array1.length : 0;
        int length2 = (array2 != null) ? array2.length : 0;
        String[] result = new String[length1 + length2];

        if (array1 != null) {
            System.arraycopy(array1, 0, result, 0, length1);
        }
        if (array2 != null) {
            System.arraycopy(array2, 0, result, length1, length2);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] array1 = {"Hello", "World"};
        String[] array2 = {"Java", "Programming"};
        String[] result = concatenateStringArrays(array1, array2);
        
        if (result != null) {
            for (String str : result) {
                System.out.println(str);
            }
        } else {
            System.out.println("Result is null");
        }
    }
}
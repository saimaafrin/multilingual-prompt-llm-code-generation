public class ArrayUtils {
    /**
     * 将给定的字符串附加到给定的字符串数组中，返回一个新数组，该数组由输入数组的内容加上给定的字符串组成。
     * @param array 要附加到的数组（可以是 <code>null</code>）
     * @param str 要附加的字符串
     * @return 新数组（绝不会是 <code>null</code>）
     */
    public static String[] addStringToArray(String[] array, String str) {
        if (array == null) {
            return new String[] {str};
        }
        
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = str;
        return newArray;
    }
}
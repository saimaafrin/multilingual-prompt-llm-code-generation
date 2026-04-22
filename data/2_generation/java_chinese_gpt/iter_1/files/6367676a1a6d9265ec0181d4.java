public class StringArrayAppender {
    
    /** 
     * 将给定的字符串附加到给定的字符串数组中，返回一个新数组，该数组由输入数组的内容加上给定的字符串组成。
     * @param array 要附加到的数组（可以是 <code>null</code>）
     * @param str 要附加的字符串
     * @return 新数组（绝不会是 <code>null</code>）
     */
    public static String[] addStringToArray(String[] array, String str) {
        int newSize = (array == null ? 0 : array.length) + 1;
        String[] newArray = new String[newSize];
        
        if (array != null) {
            System.arraycopy(array, 0, newArray, 0, array.length);
        }
        
        newArray[newSize - 1] = str;
        return newArray;
    }

    public static void main(String[] args) {
        String[] originalArray = {"Hello", "World"};
        String newString = "!";
        String[] newArray = addStringToArray(originalArray, newString);
        
        for (String s : newArray) {
            System.out.print(s + " ");
        }
    }
}
public class StringTrimmer {
    
    /**
     * 从给定的字符串中修剪所有出现的指定前导字符。
     * @param str 要检查的字符串
     * @param leadingCharacter 要修剪的前导字符
     * @return 修剪后的字符串
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (str == null) {
            return null;
        }
        
        int index = 0;
        while (index < str.length() && str.charAt(index) == leadingCharacter) {
            index++;
        }
        
        return str.substring(index);
    }

    public static void main(String[] args) {
        String result = trimLeadingCharacter("///example/string", '/');
        System.out.println(result); // Output: example/string
    }
}
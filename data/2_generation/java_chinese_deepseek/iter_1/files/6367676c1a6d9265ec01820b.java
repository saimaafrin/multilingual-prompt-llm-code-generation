public class StringUtils {

    /**
     * 删除给定字符串中的所有给定字符。
     * @param inString 原始字符串
     * @param charsToDelete 要删除的字符集合。例如 "az\n" 将删除 'a'、'z' 和换行符。
     * @return 结果字符串
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inString.length(); i++) {
            char currentChar = inString.charAt(i);
            if (charsToDelete.indexOf(currentChar) == -1) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello, World!\nThis is a test.";
        String charsToDelete = "aeiou\n";
        String result = deleteAny(input, charsToDelete);
        System.out.println(result);  // Output: Hll, Wrld!Ths s  tst.
    }
}
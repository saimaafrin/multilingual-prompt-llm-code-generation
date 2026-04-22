public class StringManipulator {

    /**
     * 删除给定字符串中的所有给定字符。
     * @param inString 原始字符串
     * @param charsToDelete 要删除的字符集合。例如 "az\n" 将删除 'a'、'z' 和换行符。
     * @return 结果字符串
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString; // Return original string if input is null
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (charsToDelete.indexOf(c) == -1) {
                result.append(c); // Append character if it's not in charsToDelete
            }
        }
        return result.toString(); // Return the modified string
    }

    public static void main(String[] args) {
        String original = "Hello, World!";
        String charsToRemove = "lo";
        String result = deleteAny(original, charsToRemove);
        System.out.println(result); // Output: "He, Wr!"
    }
}
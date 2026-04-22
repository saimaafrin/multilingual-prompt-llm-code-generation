public class StringUnescaper {
    
    /** 
     * 反转义字符串 DOT 标识符。
     * @param input 输入字符串
     * @return 反转义后的输出
     */
    private String unescapeId(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder output = new StringBuilder();
        boolean escape = false;
        
        for (char c : input.toCharArray()) {
            if (escape) {
                // If the previous character was a backslash, add the current character
                output.append(c);
                escape = false; // Reset escape flag
            } else if (c == '\\') {
                // If we encounter a backslash, set the escape flag
                escape = true;
            } else {
                // Otherwise, just add the character to the output
                output.append(c);
            }
        }
        
        return output.toString();
    }
    
    public static void main(String[] args) {
        StringUnescaper unescaper = new StringUnescaper();
        String input = "example\\:identifier\\:with\\:escapes";
        String output = unescaper.unescapeId(input);
        System.out.println(output); // Output: example:identifier:with:escapes
    }
}
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
                output.append(c);
                escape = false;
            } else if (c == '\\') {
                escape = true;
            } else {
                output.append(c);
            }
        }
        
        return output.toString();
    }

    public static void main(String[] args) {
        StringUnescaper unescaper = new StringUnescaper();
        String input = "example\\ identifier";
        String result = unescaper.unescapeId(input);
        System.out.println(result); // Output: example identifier
    }
}
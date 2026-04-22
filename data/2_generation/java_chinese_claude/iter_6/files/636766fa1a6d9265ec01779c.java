import java.util.Arrays;

public class Parser {
    private String input;
    private int currentPosition;
    
    public Parser(String input) {
        this.input = input;
        this.currentPosition = 0;
    }

    /**
     * 解析一个令牌，直到遇到某个给定的终止符。
     * @param terminators 终止字符数组。遇到这些字符中的任何一个都表示令牌的结束
     * @return 令牌
     */
    private String parseToken(final char[] terminators) {
        StringBuilder token = new StringBuilder();
        
        while (currentPosition < input.length()) {
            char currentChar = input.charAt(currentPosition);
            
            // 检查是否遇到终止符
            if (Arrays.binarySearch(terminators, currentChar) >= 0) {
                break;
            }
            
            token.append(currentChar);
            currentPosition++;
        }
        
        return token.toString();
    }
}
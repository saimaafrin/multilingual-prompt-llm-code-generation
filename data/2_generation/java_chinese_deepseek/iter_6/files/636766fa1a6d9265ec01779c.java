import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    // 将终止符数组转换为Set以便快速查找
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    StringBuilder token = new StringBuilder();
    char currentChar;

    // 假设有一个输入流或某种方式获取字符
    // 这里假设有一个方法 getNextChar() 来获取下一个字符
    while ((currentChar = getNextChar()) != '\0') {  // '\0' 表示输入结束
        if (terminatorSet.contains(currentChar)) {
            break;  // 遇到终止符，停止解析
        }
        token.append(currentChar);
    }

    return token.toString();
}

// 假设的 getNextChar() 方法，实际实现需要根据具体输入源来定义
private char getNextChar() {
    // 这里只是一个占位符，实际实现需要从输入流中读取字符
    return '\0';
}
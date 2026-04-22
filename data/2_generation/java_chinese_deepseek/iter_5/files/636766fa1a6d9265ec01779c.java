import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    // 将终止符数组转换为集合以便快速查找
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    StringBuilder token = new StringBuilder();
    char currentChar;

    // 假设有一个输入流或某种方式获取字符
    // 这里使用 System.in 作为示例
    try {
        while (true) {
            currentChar = (char) System.in.read();
            if (terminatorSet.contains(currentChar) || currentChar == '\n' || currentChar == '\r') {
                break; // 遇到终止符或换行符时停止
            }
            token.append(currentChar);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return token.toString();
}
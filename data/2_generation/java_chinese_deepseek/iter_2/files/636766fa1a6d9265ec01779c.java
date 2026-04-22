import java.util.HashSet;
import java.util.Set;

/**
 * 解析一个令牌，直到遇到某个给定的终止符。
 * @param terminators 终止字符数组。遇到这些字符中的任何一个都表示令牌的结束
 * @return 令牌
 */
private String parseToken(final char[] terminators) {
    // 将终止符数组转换为集合以便快速查找
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    StringBuilder token = new StringBuilder();
    int ch;
    while ((ch = System.in.read()) != -1) {
        char currentChar = (char) ch;
        if (terminatorSet.contains(currentChar)) {
            break;
        }
        token.append(currentChar);
    }

    return token.toString();
}
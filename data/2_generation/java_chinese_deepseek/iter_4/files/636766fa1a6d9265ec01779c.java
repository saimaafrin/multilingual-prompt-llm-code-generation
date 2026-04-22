import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    // 将终止符数组转换为集合，方便快速查找
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    StringBuilder token = new StringBuilder();
    int ch;
    while ((ch = System.in.read()) != -1) {  // 从标准输入读取字符
        char currentChar = (char) ch;
        if (terminatorSet.contains(currentChar)) {
            break;  // 遇到终止符，停止解析
        }
        token.append(currentChar);  // 将字符添加到令牌中
    }

    return token.toString();
}
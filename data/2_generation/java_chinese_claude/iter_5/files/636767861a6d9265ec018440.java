import java.lang.StringBuffer;

public class NameAbbreviator {

    /**
     * 缩写名称。
     * @param buf 用于追加缩写的缓冲区。
     * @param nameStart 要缩写的名称起始位置。
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
            return;
        }

        // 从nameStart开始遍历字符串
        for (int i = nameStart; i < buf.length(); i++) {
            char c = buf.charAt(i);
            
            // 如果是点号,保留点号和后面第一个字符
            if (c == '.') {
                if (i + 1 < buf.length()) {
                    i++;
                    // 删除点号后面的其他字符,直到下一个点号
                    int nextDot = buf.indexOf(".", i);
                    if (nextDot > 0) {
                        buf.delete(i + 1, nextDot);
                    } else {
                        // 如果没有下一个点号,删除到末尾
                        if (i + 1 < buf.length()) {
                            buf.delete(i + 1, buf.length());
                        }
                    }
                }
            }
        }
    }
}
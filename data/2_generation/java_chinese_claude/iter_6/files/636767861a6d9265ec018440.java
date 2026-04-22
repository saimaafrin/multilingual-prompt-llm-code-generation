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
            
            // 如果遇到点号,保留点号后的第一个字符,删除其他字符直到下一个点号
            if (c == '.') {
                int nextDot = buf.indexOf(".", i + 1);
                if (nextDot == -1) {
                    nextDot = buf.length();
                }
                
                // 保留点号后的第一个字符
                if (i + 1 < buf.length()) {
                    char firstChar = buf.charAt(i + 1);
                    buf.delete(i + 2, nextDot);
                }
            }
        }
    }
}
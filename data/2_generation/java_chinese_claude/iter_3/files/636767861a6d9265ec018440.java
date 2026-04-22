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
            
            // 如果是点号,保留点号和后面的字符
            if (c == '.') {
                continue;
            }
            
            // 如果是单词的第一个字符,保留
            if (i == nameStart || buf.charAt(i-1) == '.') {
                continue;
            }
            
            // 其他字符删除
            buf.deleteCharAt(i);
            i--; // 因为删除了字符,所以索引要回退
        }
    }
}
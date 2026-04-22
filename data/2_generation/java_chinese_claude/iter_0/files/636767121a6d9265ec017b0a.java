public class HeaderParser {
    /**
     * 跳过字节直到当前行的末尾。
     * @param headerPart 正在解析的头部。
     * @param end 尚未处理的最后一个字节的索引。
     * @return \r\n 表示行结束的 \r\n 序列的索引。
     */
    private int parseEndOfLine(String headerPart, int end) {
        int index = end;
        
        // 遍历字符串直到找到行尾标记 \r\n
        while (index < headerPart.length() - 1) {
            char current = headerPart.charAt(index);
            char next = headerPart.charAt(index + 1);
            
            // 检查是否找到 \r\n 序列
            if (current == '\r' && next == '\n') {
                return index;
            }
            index++;
        }
        
        // 如果没有找到行尾标记，返回字符串末尾
        return headerPart.length() - 1;
    }
}
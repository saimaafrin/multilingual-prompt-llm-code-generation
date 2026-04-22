public class LineParser {

    /** 
     * 跳过字节直到当前行的末尾。
     * @param headerPart 正在解析的头部。
     * @param end 尚未处理的最后一个字节的索引。
     * @return \r\n 表示行结束的 \r\n 序列的索引。
     */
    private int parseEndOfLine(String headerPart, int end) {
        int i = end;
        while (i < headerPart.length()) {
            char currentChar = headerPart.charAt(i);
            if (currentChar == '\r') {
                if (i + 1 < headerPart.length() && headerPart.charAt(i + 1) == '\n') {
                    return i + 1; // Return the index after \r\n
                }
            } else if (currentChar == '\n') {
                return i; // Return the index after \n
            }
            i++;
        }
        return headerPart.length(); // Return the length if no end of line is found
    }
}
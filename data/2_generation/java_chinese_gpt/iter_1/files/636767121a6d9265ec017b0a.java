public class LineParser {

    /**
     * 跳过字节直到当前行的末尾。
     * @param headerPart 正在解析的头部。
     * @param end 尚未处理的最后一个字节的索引。
     * @return \r\n 表示行结束的 \r\n 序列的索引。
     */
    private int parseEndOfLine(String headerPart, int end) {
        int length = headerPart.length();
        for (int i = end; i < length; i++) {
            if (headerPart.charAt(i) == '\r') {
                if (i + 1 < length && headerPart.charAt(i + 1) == '\n') {
                    return i + 1; // Return the index after \r\n
                }
            }
            if (headerPart.charAt(i) == '\n') {
                return i; // Return the index after \n
            }
        }
        return length; // If no end of line is found, return the length of the string
    }

    public static void main(String[] args) {
        LineParser parser = new LineParser();
        String header = "This is a test header.\r\nNext line starts here.";
        int endIndex = parser.parseEndOfLine(header, 0);
        System.out.println("End of line index: " + endIndex);
    }
}
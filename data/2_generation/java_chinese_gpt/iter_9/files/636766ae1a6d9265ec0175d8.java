public class ContentRangeBuilder {

    /**
     * 构建 'Content-Range' HTTP 头部值。
     * @return 'Content-Range' 值
     */
    private String buildContentRange() {
        long start = 0; // 起始字节
        long end = 1023; // 结束字节
        long total = 2048; // 总字节数

        return String.format("bytes %d-%d/%d", start, end, total);
    }

    public static void main(String[] args) {
        ContentRangeBuilder builder = new ContentRangeBuilder();
        String contentRange = builder.buildContentRange();
        System.out.println(contentRange);
    }
}
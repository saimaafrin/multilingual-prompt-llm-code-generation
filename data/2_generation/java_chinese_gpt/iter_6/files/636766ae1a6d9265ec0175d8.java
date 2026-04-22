public class ContentRangeBuilder {

    /**
     * 构建 'Content-Range' HTTP 头部值。
     * @return 'Content-Range' 值
     */
    private String buildContentRange() {
        // 示例值，实际值应根据具体情况生成
        long start = 0;
        long end = 499;
        long total = 1234;

        return String.format("bytes %d-%d/%d", start, end, total);
    }

    public static void main(String[] args) {
        ContentRangeBuilder builder = new ContentRangeBuilder();
        String contentRange = builder.buildContentRange();
        System.out.println(contentRange);
    }
}
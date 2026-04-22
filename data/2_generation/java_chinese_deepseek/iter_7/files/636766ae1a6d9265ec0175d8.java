/**
 * 构建 'Content-Range' HTTP 头部值。
 * @return 'Content-Range' 值
 */
private String buildContentRange(long start, long end, long total) {
    return String.format("bytes %d-%d/%d", start, end, total);
}
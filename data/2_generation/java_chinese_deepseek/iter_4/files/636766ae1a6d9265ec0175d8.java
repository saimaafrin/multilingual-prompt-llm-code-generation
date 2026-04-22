/**
 * 构建 'Content-Range' HTTP 头部值。
 * @return 'Content-Range' 值
 */
private String buildContentRange() {
    // 假设我们有一个文件的总大小和当前读取的范围
    long totalSize = 1024; // 文件总大小
    long start = 0; // 起始字节
    long end = 511; // 结束字节

    // 构建 Content-Range 头部值
    return String.format("bytes %d-%d/%d", start, end, totalSize);
}
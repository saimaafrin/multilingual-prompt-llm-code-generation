/**
 * 构建 'Content-Range' HTTP 头部值。
 * @return 'Content-Range' 值
 */
private String buildContentRange() {
    // 假设我们有一个文件的起始字节和结束字节
    long startByte = 0; // 起始字节
    long endByte = 1023; // 结束字节
    long totalBytes = 2048; // 文件总字节数

    // 构建 Content-Range 头部值
    return String.format("bytes %d-%d/%d", startByte, endByte, totalBytes);
}
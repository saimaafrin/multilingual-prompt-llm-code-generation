/**
 * 如果主体是字节数组，则返回真
 * @return 如果主体是字节数组，则返回真
 */
public boolean hasBytes() {
    // 假设主体是一个字节数组
    byte[] body = getBody(); // 假设有一个方法 getBody() 返回主体

    // 检查主体是否为字节数组
    return body != null && body instanceof byte[];
}

// 假设的 getBody() 方法
private byte[] getBody() {
    // 返回一个字节数组或 null
    return new byte[0]; // 示例返回一个空的字节数组
}
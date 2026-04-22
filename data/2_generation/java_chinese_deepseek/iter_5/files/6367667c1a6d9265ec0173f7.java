/**
 * 如果主体是字节数组，则返回真
 * @return 如果主体是字节数组，则返回真
 */
public boolean hasBytes() {
    // 假设主体是一个字节数组
    byte[] body = getBody(); // 假设getBody()方法返回主体的字节数组
    return body != null && body instanceof byte[];
}

// 假设的getBody方法，用于获取主体
private byte[] getBody() {
    // 这里返回一个示例字节数组
    return new byte[0];
}
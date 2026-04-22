/**
 * 如果主体是字节数组，则返回真
 * @return 如果主体是字节数组，则返回真
 */
public boolean hasBytes() {
    // 假设主体是一个字节数组
    byte[] body = getBody(); // 假设getBody()方法返回主体
    return body != null && body instanceof byte[];
}

// 假设的getBody方法，用于获取主体
private Object getBody() {
    // 这里返回一个字节数组或其他类型的对象
    return new byte[0]; // 示例返回一个空的字节数组
}
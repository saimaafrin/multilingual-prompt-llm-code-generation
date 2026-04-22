/**
 * 扩展此字节向量，以便能够接收 'size' 个额外的字节。
 * @param size 此字节向量应该能够接收的额外字节数。
 */
private void enlarge(final int size) {
    // 假设当前字节数组为 byteArray，当前容量为 capacity
    int newCapacity = byteArray.length + size;
    byte[] newByteArray = new byte[newCapacity];
    
    // 将原有数据复制到新数组中
    System.arraycopy(byteArray, 0, newByteArray, 0, byteArray.length);
    
    // 更新字节数组引用
    byteArray = newByteArray;
}
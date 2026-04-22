import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 将字节复制到 {@code byte[]} 中。
 */
public byte[] toByteArray() {
    // 假设我们有一个输入流或其他数据源
    // 这里我们使用 ByteArrayOutputStream 来模拟数据的复制
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    
    // 假设我们有一些数据要写入
    byte[] data = "Hello, World!".getBytes();
    
    try {
        outputStream.write(data);
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    // 返回复制后的字节数组
    return outputStream.toByteArray();
}
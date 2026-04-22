import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 将字节复制到 {@code byte[]} 中。
 */
public byte[] toByteArray() {
    // 假设我们有一个字节流作为输入
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    byte[] data = {0x01, 0x02, 0x03, 0x04}; // 示例数据

    try {
        outputStream.write(data);
    } catch (IOException e) {
        e.printStackTrace();
    }

    return outputStream.toByteArray();
}
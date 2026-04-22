import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 将字节复制到 {@code byte[]} 中。
 */
public byte[] toByteArray() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    try {
        // 假设这里有一些字节数据需要写入到 outputStream 中
        // 例如：outputStream.write(someByteData);
        outputStream.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return outputStream.toByteArray();
}
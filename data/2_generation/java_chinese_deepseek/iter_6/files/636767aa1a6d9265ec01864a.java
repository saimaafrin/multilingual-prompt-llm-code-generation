import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayConverter {

    /**
     * 将字节复制到 {@code byte[]} 中。
     * 
     * @return 包含复制字节的字节数组
     */
    public byte[] toByteArray() {
        // 假设我们有一个字节流，这里使用 ByteArrayOutputStream 作为示例
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        // 假设我们要将一些数据写入到字节流中
        try {
            outputStream.write("Hello, World!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 将字节流转换为字节数组并返回
        return outputStream.toByteArray();
    }

    public static void main(String[] args) {
        ByteArrayConverter converter = new ByteArrayConverter();
        byte[] byteArray = converter.toByteArray();
        System.out.println(new String(byteArray)); // 输出: Hello, World!
    }
}
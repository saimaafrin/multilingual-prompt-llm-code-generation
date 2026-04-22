import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayExample {
    
    private byte[] data;

    public ByteArrayExample(byte[] data) {
        this.data = data;
    }

    /** 
     * 将字节复制到 {@code byte[]} 中。
     */
    public byte[] toByteArray() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    public static void main(String[] args) {
        byte[] originalData = {1, 2, 3, 4, 5};
        ByteArrayExample example = new ByteArrayExample(originalData);
        byte[] copiedData = example.toByteArray();
        
        // Print copied data
        for (byte b : copiedData) {
            System.out.print(b + " ");
        }
    }
}
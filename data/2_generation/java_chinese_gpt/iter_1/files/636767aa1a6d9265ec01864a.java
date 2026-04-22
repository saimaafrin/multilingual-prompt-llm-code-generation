import java.nio.ByteBuffer;

public class ByteArrayConverter {
    
    private byte[] data;

    public ByteArrayConverter(byte[] data) {
        this.data = data;
    }

    /** 
     * 将字节复制到 {@code byte[]} 中。
     */
    public byte[] toByteArray() {
        return data.clone();
    }

    public static void main(String[] args) {
        byte[] originalData = {1, 2, 3, 4, 5};
        ByteArrayConverter converter = new ByteArrayConverter(originalData);
        byte[] copiedData = converter.toByteArray();

        // Print the copied data
        for (byte b : copiedData) {
            System.out.print(b + " ");
        }
    }
}
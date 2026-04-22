import java.nio.ByteBuffer;

public class ByteArrayConverter {

    private byte[] bytes;

    public ByteArrayConverter(byte[] bytes) {
        this.bytes = bytes;
    }

    /** 
     * बाइट्स को {@code byte[]} में कॉपी करता है।
     */
    public byte[] toByteArray() {
        return bytes.clone();
    }

    public static void main(String[] args) {
        byte[] originalBytes = {1, 2, 3, 4, 5};
        ByteArrayConverter converter = new ByteArrayConverter(originalBytes);
        byte[] copiedBytes = converter.toByteArray();

        // Print copied bytes
        for (byte b : copiedBytes) {
            System.out.print(b + " ");
        }
    }
}
import java.nio.ByteBuffer;

public class ByteArrayConverter {
    
    /** 
     * बाइट्स को {@code byte[]} में कॉपी करता है।
     */
    public byte[] toByteArray() {
        // Example byte array for demonstration
        byte[] byteArray = new byte[10];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = (byte) i;
        }
        return byteArray;
    }

    public static void main(String[] args) {
        ByteArrayConverter converter = new ByteArrayConverter();
        byte[] result = converter.toByteArray();
        for (byte b : result) {
            System.out.print(b + " ");
        }
    }
}
import java.nio.ByteBuffer;

public class ByteArrayConverter {
    
    /** 
     * बाइट्स को {@code byte[]} में कॉपी करता है।
     */
    public byte[] toByteArray() {
        // Example byte array for demonstration
        byte[] exampleBytes = {1, 2, 3, 4, 5};
        return exampleBytes;
    }

    public static void main(String[] args) {
        ByteArrayConverter converter = new ByteArrayConverter();
        byte[] byteArray = converter.toByteArray();
        
        // Print the byte array
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }
    }
}
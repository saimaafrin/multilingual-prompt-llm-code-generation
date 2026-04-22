import java.nio.ByteBuffer;

public class ByteArrayConverter {
    
    /** 
     * बाइट्स को {@code byte[]} में कॉपी करता है।
     */
    public byte[] toByteArray() {
        // Example byte array to demonstrate the functionality
        byte[] exampleBytes = {1, 2, 3, 4, 5};
        return exampleBytes.clone(); // Cloning to return a new byte array
    }

    public static void main(String[] args) {
        ByteArrayConverter converter = new ByteArrayConverter();
        byte[] byteArray = converter.toByteArray();
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }
    }
}
import java.util.Arrays;

public class ArrayComparer {
    
    /** 
     * 如果内部数组的内容与提供的数组匹配，则返回真。
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        // Check for null or invalid parameters
        if (data == null || offset < 0 || len < 0 || offset + len > data.length) {
            return false;
        }
        
        // Create an internal array for comparison (for demonstration purposes)
        byte[] internalArray = new byte[len];
        // Fill the internal array with some values (for demonstration purposes)
        for (int i = 0; i < len; i++) {
            internalArray[i] = (byte) i; // Example values
        }
        
        // Compare the internal array with the provided data array
        return Arrays.equals(internalArray, Arrays.copyOfRange(data, offset, offset + len));
    }
    
    public static void main(String[] args) {
        ArrayComparer comparer = new ArrayComparer();
        byte[] data = {0, 1, 2, 3, 4, 5};
        boolean result = comparer.equals(data, 0, 3);
        System.out.println("Arrays are equal: " + result); // Should print true or false based on the internal array
    }
}
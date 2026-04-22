public class NonZeroCounter {
    
    /**
     * एक पंक्ति के गैर-शून्य प्रविष्टियों की संख्या प्राप्त करें।
     * @param row पंक्ति
     * @return एक पंक्ति के गैर-शून्य प्रविष्टियों की संख्या
     */
    public int nonZeros(int row) {
        // Assuming row is an integer representing a binary number
        int count = 0;
        
        // Count non-zero entries (1s) in the binary representation of the row
        while (row > 0) {
            count += (row & 1); // Check if the last bit is 1
            row >>= 1; // Right shift to check the next bit
        }
        
        return count;
    }

    public static void main(String[] args) {
        NonZeroCounter counter = new NonZeroCounter();
        int row = 13; // Example input (binary 1101)
        System.out.println("Non-zero entries: " + counter.nonZeros(row)); // Output: 3
    }
}
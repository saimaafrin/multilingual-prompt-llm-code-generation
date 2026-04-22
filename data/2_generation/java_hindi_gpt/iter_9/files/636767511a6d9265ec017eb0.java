public class NonZeroCounter {
    
    /**
     * एक पंक्ति के गैर-शून्य प्रविष्टियों की संख्या प्राप्त करें।
     * @param row पंक्ति
     * @return एक पंक्ति के गैर-शून्य प्रविष्टियों की संख्या
     */
    public int nonZeros(int row) {
        // Assuming row is represented as an integer where each digit represents an entry
        String rowString = String.valueOf(row);
        int count = 0;
        
        for (char ch : rowString.toCharArray()) {
            if (ch != '0') {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        NonZeroCounter counter = new NonZeroCounter();
        int row = 102030; // Example input
        System.out.println("Non-zero entries: " + counter.nonZeros(row)); // Output: 3
    }
}
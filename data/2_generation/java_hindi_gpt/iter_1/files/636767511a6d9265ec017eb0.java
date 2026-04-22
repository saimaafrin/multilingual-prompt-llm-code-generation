public class NonZeroCounter {
    
    /**
     * एक पंक्ति के गैर-शून्य प्रविष्टियों की संख्या प्राप्त करें।
     * @param row पंक्ति
     * @return एक पंक्ति के गैर-शून्य प्रविष्टियों की संख्या
     */
    public int nonZeros(int row) {
        // Assuming row is an integer where each digit represents an entry
        int count = 0;
        while (row != 0) {
            if (row % 10 != 0) {
                count++;
            }
            row /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        NonZeroCounter counter = new NonZeroCounter();
        int row = 102030; // Example input
        System.out.println("गैर-शून्य प्रविष्टियों की संख्या: " + counter.nonZeros(row));
    }
}
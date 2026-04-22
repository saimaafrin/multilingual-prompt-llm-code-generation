public class NonZeroCounter {
    /**
     * Get the number of non-zero entries of a row.
     * @param row the row represented as an array of integers
     * @return the number of non-zero entries of a row
     */
    public int nonZeros(int[] row) {
        int count = 0;
        for (int value : row) {
            if (value != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NonZeroCounter counter = new NonZeroCounter();
        int[] row = {0, 5, 0, 3, 0, 8};
        System.out.println("Number of non-zero entries: " + counter.nonZeros(row));
    }
}
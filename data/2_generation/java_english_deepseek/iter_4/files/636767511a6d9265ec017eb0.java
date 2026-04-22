public class RowUtils {

    /**
     * Get the number of non-zero entries of a row.
     * @param row the row represented as an array of integers
     * @return the number of non-zero entries of a row
     */
    public static int nonZeros(int[] row) {
        int count = 0;
        for (int value : row) {
            if (value != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] row = {0, 5, 0, 3, 0, 1};
        System.out.println("Number of non-zero entries: " + nonZeros(row));
    }
}
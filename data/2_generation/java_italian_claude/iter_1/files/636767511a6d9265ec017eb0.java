public class Matrix {
    private int[][] matrix;
    private int rows;
    private int cols;

    /**
     * Ottiene il numero di voci diverse da zero in una riga.
     * @param row la riga
     * @return il numero di voci diverse da zero in una riga
     */
    public int nonZeros(int row) {
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row index");
        }

        int count = 0;
        for (int j = 0; j < cols; j++) {
            if (matrix[row][j] != 0) {
                count++;
            }
        }
        return count;
    }
}
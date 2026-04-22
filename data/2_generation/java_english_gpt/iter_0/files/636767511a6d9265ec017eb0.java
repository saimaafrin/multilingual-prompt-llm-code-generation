public class MatrixUtils {
    
    private int[][] matrix;

    public MatrixUtils(int[][] matrix) {
        this.matrix = matrix;
    }

    /** 
     * Get the number of non-zero entries of a row.
     * @param row the row
     * @return the number of non-zero entries of a row
     */
    public int nonZeros(int row) {
        if (row < 0 || row >= matrix.length) {
            throw new IllegalArgumentException("Row index out of bounds");
        }
        
        int count = 0;
        for (int value : matrix[row]) {
            if (value != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] sampleMatrix = {
            {1, 0, 3},
            {0, 0, 0},
            {4, 5, 0}
        };
        
        MatrixUtils matrixUtils = new MatrixUtils(sampleMatrix);
        System.out.println("Non-zero entries in row 0: " + matrixUtils.nonZeros(0)); // Output: 2
        System.out.println("Non-zero entries in row 1: " + matrixUtils.nonZeros(1)); // Output: 0
        System.out.println("Non-zero entries in row 2: " + matrixUtils.nonZeros(2)); // Output: 2
    }
}
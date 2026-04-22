import java.util.Arrays;

public class Matrix {
    private double[][] matrix; // Assuming matrix is stored as a 2D array
    
    /**
     * 获取一行中非零条目的数量。
     * @param row 行号
     * @return 一行中非零条目的数量
     */
    public int nonZeros(int row) {
        if (row < 0 || row >= matrix.length) {
            throw new IllegalArgumentException("Invalid row index");
        }
        
        int count = 0;
        for (int col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] != 0) {
                count++;
            }
        }
        return count;
    }
}
import java.util.Arrays;

public class Matrix {
    private double[][] data;
    
    /**
     * Get the number of non-zero entries of a row.
     * @param row the row
     * @return the number of non-zero entries of a row
     */
    public int nonZeros(int row) {
        if (row < 0 || row >= data.length) {
            throw new IllegalArgumentException("Invalid row index");
        }
        
        return (int) Arrays.stream(data[row])
                         .filter(x -> x != 0.0)
                         .count();
    }
}
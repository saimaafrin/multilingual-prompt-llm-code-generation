import java.util.Arrays;

public class MatrixUtils {
    /**
     * Get the number of non-zero entries of a row.
     * @param row the row
     * @return the number of non-zero entries of a row
     */
    public static int getNonZeroCount(double[] row) {
        return (int) Arrays.stream(row)
                         .filter(x -> x != 0.0)
                         .count();
    }
}
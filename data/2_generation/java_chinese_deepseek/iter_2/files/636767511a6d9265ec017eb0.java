import java.util.*;

public class MatrixUtils {
    /**
     * 获取一行中非零条目的数量。
     * @param row 行号
     * @return 一行中非零条目的数量
     */
    public int nonZeros(int row) {
        // 假设矩阵是一个二维数组
        int[][] matrix = {
            {1, 0, 3, 0},
            {0, 0, 0, 0},
            {2, 0, 4, 5},
            {0, 6, 0, 0}
        };

        if (row < 0 || row >= matrix.length) {
            throw new IllegalArgumentException("Invalid row number");
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
        MatrixUtils utils = new MatrixUtils();
        System.out.println(utils.nonZeros(2)); // 示例调用
    }
}
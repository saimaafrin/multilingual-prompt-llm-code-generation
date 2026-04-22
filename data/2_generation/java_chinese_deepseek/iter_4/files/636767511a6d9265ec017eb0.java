public class NonZeroCounter {
    /**
     * 获取一行中非零条目的数量。
     * @param row 行号
     * @return 一行中非零条目的数量
     */
    public int nonZeros(int row) {
        // 假设我们有一个二维数组 matrix 表示矩阵
        int[][] matrix = {
            {1, 0, 3, 0},
            {0, 0, 0, 0},
            {2, 0, 4, 5},
            {0, 6, 0, 0}
        };

        // 检查行号是否有效
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
        NonZeroCounter counter = new NonZeroCounter();
        int row = 2; // 示例行号
        System.out.println("Non-zero entries in row " + row + ": " + counter.nonZeros(row));
    }
}
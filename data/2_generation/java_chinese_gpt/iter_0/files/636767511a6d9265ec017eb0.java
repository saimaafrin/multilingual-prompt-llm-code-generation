public class Matrix {
    private int[][] data;

    public Matrix(int[][] data) {
        this.data = data;
    }

    /** 
     * 获取一行中非零条目的数量。
     * @param row 行号
     * @return 一行中非零条目的数量
     */
    public int nonZeros(int row) {
        if (row < 0 || row >= data.length) {
            throw new IllegalArgumentException("Invalid row number");
        }
        
        int count = 0;
        for (int value : data[row]) {
            if (value != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrixData = {
            {1, 0, 2, 0},
            {0, 0, 0, 0},
            {3, 4, 0, 5}
        };
        
        Matrix matrix = new Matrix(matrixData);
        System.out.println("Non-zero entries in row 0: " + matrix.nonZeros(0)); // Output: 2
        System.out.println("Non-zero entries in row 1: " + matrix.nonZeros(1)); // Output: 0
        System.out.println("Non-zero entries in row 2: " + matrix.nonZeros(2)); // Output: 3
    }
}
public class NonZeroCounter {
    
    private int[][] matrix; // Assuming a 2D array to represent the matrix

    public NonZeroCounter(int[][] matrix) {
        this.matrix = matrix;
    }

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
        for (int value : matrix[row]) {
            if (value != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] sampleMatrix = {
            {1, 0, 2, 0},
            {0, 0, 0, 0},
            {3, 4, 0, 5}
        };
        
        NonZeroCounter counter = new NonZeroCounter(sampleMatrix);
        System.out.println("Non-zero entries in row 0: " + counter.nonZeros(0)); // Output: 2
        System.out.println("Non-zero entries in row 1: " + counter.nonZeros(1)); // Output: 0
        System.out.println("Non-zero entries in row 2: " + counter.nonZeros(2)); // Output: 3
    }
}
public class MatrixUtils {

    /**
     * 获取一行中非零条目的数量。
     * @param row 行号
     * @return 一行中非零条目的数量
     */
    public int nonZeros(int[] row) {
        int count = 0;
        for (int value : row) {
            if (value != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MatrixUtils utils = new MatrixUtils();
        int[] row = {0, 5, 0, 3, 0, 8};
        System.out.println("Non-zero entries: " + utils.nonZeros(row));
    }
}
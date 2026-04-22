public class MatrixUtils {

    /**
     * Obtiene el número de entradas diferentes de cero en una fila.
     * @param row la fila
     * @return el número de entradas diferentes de cero en una fila
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
        int[] row = {1, 0, 2, 0, 3};
        System.out.println("Número de entradas diferentes de cero: " + utils.nonZeros(row)); // Output: 3
    }
}
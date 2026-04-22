public class Matrix {
    private int[][] matrix;
    
    /**
     * Obtiene el número de entradas diferentes de cero en una fila.
     * @param row la fila
     * @return el número de entradas diferentes de cero en una fila
     */
    public int nonZeros(int row) {
        int count = 0;
        for(int j = 0; j < matrix[row].length; j++) {
            if(matrix[row][j] != 0) {
                count++;
            }
        }
        return count;
    }
}
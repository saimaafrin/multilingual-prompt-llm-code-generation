public class NonZeroCounter {
    /**
     * Obtiene el número de entradas diferentes de cero en una fila.
     * @param row la fila
     * @return el número de entradas diferentes de cero en una fila
     */
    public static int nonZeros(int[] row) {
        int count = 0;
        for (int value : row) {
            if (value != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] row = {0, 5, 0, 3, 0, 8};
        System.out.println("Número de entradas diferentes de cero: " + nonZeros(row));
    }
}
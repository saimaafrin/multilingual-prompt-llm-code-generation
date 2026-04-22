public class NonZeroCounter {

    /**
     * Obtiene el número de entradas diferentes de cero en una fila.
     * @param row la fila representada como un arreglo de enteros
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
        int[] row = {0, 5, 0, 3, 0, 0, 7};
        System.out.println("Número de entradas diferentes de cero: " + nonZeros(row));
    }
}
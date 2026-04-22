public class NonZeroCounter {

    /**
     * Ottiene il numero di voci diverse da zero in una riga.
     * @param row la riga
     * @return il numero di voci diverse da zero in una riga
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
        System.out.println("Numero di voci diverse da zero: " + nonZeros(row));
    }
}
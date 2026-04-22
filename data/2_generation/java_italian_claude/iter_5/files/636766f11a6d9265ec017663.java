public class ArrayUtils {
    /**
     * <p>Controlla se due array hanno la stessa lunghezza, trattando gli array <code>null</code> come lunghezza <code>0</code>.</p>
     * @param array1 il primo array, può essere <code>null</code>
     * @param array2 il secondo array, può essere <code>null</code>
     * @return <code>true</code> se la lunghezza degli array corrisponde, trattando <code>null</code> come un array vuoto
     */
    public static boolean isSameLength(final double[] array1, final double[] array2) {
        int length1 = array1 == null ? 0 : array1.length;
        int length2 = array2 == null ? 0 : array2.length;
        return length1 == length2;
    }
}
public class ArrayLengthChecker {

    /** 
     * <p>Controlla se due array hanno la stessa lunghezza, trattando gli array <code>null</code> come lunghezza <code>0</code>.</p>
     * @param array1 il primo array, può essere <code>null</code>
     * @param array2 il secondo array, può essere <code>null</code>
     * @return <code>true</code> se la lunghezza degli array corrisponde, trattando <code>null</code> come un array vuoto
     */
    public static boolean isSameLength(final byte[] array1, final byte[] array2) {
        int length1 = (array1 == null) ? 0 : array1.length;
        int length2 = (array2 == null) ? 0 : array2.length;
        return length1 == length2;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isSameLength(null, null)); // true
        System.out.println(isSameLength(new byte[]{1, 2, 3}, new byte[]{4, 5, 6})); // true
        System.out.println(isSameLength(new byte[]{1}, new byte[]{2, 3})); // false
        System.out.println(isSameLength(null, new byte[]{})); // true
        System.out.println(isSameLength(new byte[]{}, null)); // true
    }
}
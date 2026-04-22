public class ByteArrayComparator {
    /**
     * Compares <code>count</code> first bytes in the arrays <code>a</code> and <code>b</code>.
     * @param a     The first array to compare.
     * @param b     The second array to compare.
     * @param count How many bytes should be compared.
     * @return <code>true</code> if <code>count</code> first bytes in arrays <code>a</code> and <code>b</code> are equal.
     */
    public static boolean arrayequals(byte[] a, byte[] b, int count) {
        if (a == null || b == null) {
            return a == b; // Both null or one null
        }
        if (a.length < count || b.length < count) {
            return false; // Not enough bytes to compare
        }
        for (int i = 0; i < count; i++) {
            if (a[i] != b[i]) {
                return false; // Mismatch found
            }
        }
        return true; // All bytes match
    }

    public static void main(String[] args) {
        byte[] a = {1, 2, 3, 4, 5};
        byte[] b = {1, 2, 3, 4, 6};
        int count = 4;
        System.out.println(arrayequals(a, b, count)); // Output: true
    }
}
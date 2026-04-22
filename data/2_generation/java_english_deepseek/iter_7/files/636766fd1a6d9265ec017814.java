public class ByteArrayComparator {
    /**
     * Compares <code>count</code> first bytes in the arrays <code>a</code> and <code>b</code>.
     * @param a     The first array to compare.
     * @param b     The second array to compare.
     * @param count How many bytes should be compared.
     * @return <code>true</code> if <code>count</code> first bytes in arrays<code>a</code> and <code>b</code> are equal.
     */
    public static boolean arrayequals(byte[] a, byte[] b, int count) {
        if (a == null || b == null) {
            return false;
        }
        if (a.length < count || b.length < count) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        byte[] array1 = {1, 2, 3, 4, 5};
        byte[] array2 = {1, 2, 3, 4, 6};
        byte[] array3 = {1, 2, 3, 4, 5};

        System.out.println(arrayequals(array1, array2, 4)); // true
        System.out.println(arrayequals(array1, array2, 5)); // false
        System.out.println(arrayequals(array1, array3, 5)); // true
    }
}
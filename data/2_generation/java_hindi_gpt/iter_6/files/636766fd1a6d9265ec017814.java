public class ArrayComparator {
    
    /** 
     * <code>a</code> और <code>b</code> ऐरे में पहले <code>count</code> बाइट्स की तुलना करता है।
     * @param a     तुलना के लिए पहला ऐरे।
     * @param b     तुलना के लिए दूसरा ऐरे।
     * @param count कितनी बाइट्स की तुलना की जानी चाहिए।
     * @return <code>true</code> यदि <code>a</code> और <code>b</code> ऐरे में पहले <code>count</code> बाइट्स समान हैं।
     */
    public static boolean arrayequals(byte[] a, byte[] b, int count) {
        if (a == null || b == null || count < 0 || count > a.length || count > b.length) {
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
        int count = 3;

        boolean result = arrayequals(array1, array2, count);
        System.out.println("Are the first " + count + " bytes equal? " + result);
    }
}
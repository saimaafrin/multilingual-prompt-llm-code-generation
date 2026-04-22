public class ArrayUtils {
    /**
     * Confronta i <code>count</code> primi byte negli array <code>a</code> e <code>b</code>.
     * @param a     Il primo array da confrontare.
     * @param b     Il secondo array da confrontare. 
     * @param count Quanti byte devono essere confrontati.
     * @return <code>true</code> se i <code>count</code> primi byte negli array <code>a</code> e <code>b</code> sono uguali.
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
}
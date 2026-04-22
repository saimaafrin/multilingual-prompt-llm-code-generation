public class ArrayUtils {
    /**
     * Compara los <code>count</code> primeros bytes en los arreglos <code>a</code> y <code>b</code>.
     * @param a     El primer arreglo a comparar.
     * @param b     El segundo arreglo a comparar. 
     * @param count Cuántos bytes se deben comparar.
     * @return <code>true</code> si los <code>count</code> primeros bytes en los arreglos <code>a</code> y <code>b</code> son iguales.
     */
    public static boolean arrayequals(byte[] a, byte[] b, int count) {
        // Check for null arrays
        if (a == null || b == null) {
            return false;
        }
        
        // Check if count is valid
        if (count < 0 || count > a.length || count > b.length) {
            return false;
        }
        
        // Compare the first count bytes
        for (int i = 0; i < count; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        
        return true;
    }
}
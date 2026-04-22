public class ArrayUtils {
    /**
     * Compara los <code>count</code> primeros bytes en los arreglos <code>a</code> y <code>b</code>.
     * @param a     El primer arreglo a comparar.
     * @param b     El segundo arreglo a comparar. 
     * @param count Cuántos bytes se deben comparar.
     * @return <code>true</code> si los <code>count</code> primeros bytes en los arreglos <code>a</code> y <code>b</code> son iguales.
     */
    public static boolean arrayequals(byte[] a, byte[] b, int count) {
        // Verificar si alguno de los arreglos es null
        if (a == null || b == null) {
            return false;
        }
        
        // Verificar si count es válido
        if (count < 0) {
            return false;
        }
        
        // Verificar si hay suficientes elementos para comparar
        if (a.length < count || b.length < count) {
            return false;
        }
        
        // Comparar los primeros count bytes
        for (int i = 0; i < count; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        
        return true;
    }
}